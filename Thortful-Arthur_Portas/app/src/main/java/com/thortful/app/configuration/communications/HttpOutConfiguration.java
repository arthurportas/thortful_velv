package com.thortful.app.configuration.communications;

import com.thortful.adapters.http.out.api.exceptions.ExceptionConverter;
import com.thortful.adapters.http.out.api.tmdb.MoviesFetcher;
import com.thortful.http.out.configuration.HttpObjectMapperSupplier;
import com.thortful.http.out.tmdb.converters.TmdbTrendingMoviesResponseConverter;
import com.thortful.http.out.tmdb.fetchers.MoviesFetcherImpl;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
@RequiredArgsConstructor
public class HttpOutConfiguration {

    private final TmdbProperties tmdbProperties;

    @Bean
    MoviesFetcher moviesFetcher(Retrofit.Builder tmdbRetroFitBuilder,
                                ExceptionConverter exceptionConverter,
                                TmdbTrendingMoviesResponseConverter tmdbTrendingMoviesResponseConverter) {
        return new MoviesFetcherImpl(
                tmdbRetroFitBuilder,
                exceptionConverter,
                tmdbTrendingMoviesResponseConverter,
                tmdbProperties.getAuthorizationToken()
        );
    }

    //converter beans
    @Bean
    TmdbTrendingMoviesResponseConverter tmdbTrendingMoviesResponseConverter() {

        return new TmdbTrendingMoviesResponseConverter();
    }

    @Bean
    ExceptionConverter exceptionConverter() {

        return new ExceptionConverter();
    }

    @Bean
    HttpObjectMapperSupplier httpObjectMapperSupplier() {

        return new HttpObjectMapperSupplier();
    }

    //retrofit beans
    @Bean
    Retrofit.Builder tmdbRetroFitBuilder(HttpObjectMapperSupplier httpObjectMapperSupplier) {

        return buildRetrofit(httpObjectMapperSupplier, tmdbProperties);
    }

    Retrofit.Builder buildRetrofit(HttpObjectMapperSupplier httpObjectMapperSupplier,
                                   HttpOutProperties httpOutProperties) {

        return buildRetroFit(httpObjectMapperSupplier,
                httpOutProperties.getHost(),
                httpOutProperties.getMaxIdleConnections(),
                httpOutProperties.getKeepAlive(),
                httpOutProperties.getReadTimeout(),
                httpOutProperties.getConnectionTimeout()
        );
    }

    private Retrofit.Builder buildRetroFit(HttpObjectMapperSupplier httpObjectMapperSupplier,
                                           String host,
                                           int maxIdleConnections,
                                           int keepAlive,
                                           int readTimeout,
                                           int connectionTimeout) {

        final ConnectionPool pool = new ConnectionPool(maxIdleConnections, keepAlive, TimeUnit.MILLISECONDS);

        final OkHttpClient client = new OkHttpClient.Builder()
                .connectionPool(pool)
                .readTimeout(readTimeout, TimeUnit.MILLISECONDS)
                .connectTimeout(connectionTimeout, TimeUnit.MILLISECONDS)
                .build();

        return new Retrofit.Builder()
                .client(client)
                .baseUrl(host)
                .addConverterFactory(JacksonConverterFactory.create(httpObjectMapperSupplier.get()));
    }

    @Data
    abstract static class HttpOutProperties {

        private String host;

        private int readTimeout;

        private int connectionTimeout;

        private int maxIdleConnections;

        private int keepAlive;
    }

    @EqualsAndHashCode(callSuper = true)
    @Configuration
    @ConfigurationProperties("http.out.tmdb")
    @Data
    static class TmdbProperties extends HttpOutProperties {

        private String authorizationToken;
    }
}
