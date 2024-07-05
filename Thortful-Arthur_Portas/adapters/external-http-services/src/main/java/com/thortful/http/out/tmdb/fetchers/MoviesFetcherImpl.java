package com.thortful.http.out.tmdb.fetchers;

import com.thortful.adapters.http.out.api.exceptions.ErrorCode;
import com.thortful.adapters.http.out.api.exceptions.ExceptionConverter;
import com.thortful.adapters.http.out.api.exceptions.HttpException;
import com.thortful.adapters.http.out.api.tmdb.MoviesFetcher;
import com.thortful.domain.catalog.PageRequest;
import com.thortful.domain.catalog.TrendingMoviesPage;
import com.thortful.http.out.tmdb.converters.TmdbTrendingMoviesResponseConverter;
import com.thortful.http.out.tmdb.responses.TmdbTrendingMoviesResponse;
import lombok.Getter;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import java.util.function.Supplier;

public class MoviesFetcherImpl extends TmdbFectherImpl implements MoviesFetcher {

    @Getter
    private final String authorizationToken;

    private final ExceptionConverter exceptionConverter;

    private final TmdbTrendingMoviesResponseConverter responseConverter;


    public MoviesFetcherImpl(
            final Retrofit.Builder retrofitBuilder,
            final ExceptionConverter exceptionConverter,
            final TmdbTrendingMoviesResponseConverter responseConverter,
            final String authorizationToken
    ) {
        super(retrofitBuilder);
        this.exceptionConverter = exceptionConverter;
        this.responseConverter = responseConverter;
        this.authorizationToken = authorizationToken;

    }

    @Override
    public TrendingMoviesPage getTrendingMovies(PageRequest pageRequest) {

        final Supplier<TrendingMoviesPage> getTrendingMovies = () -> {

            try {

                final Call<TmdbTrendingMoviesResponse> retrofitCall = getTmdbApi()
                        .getTrendingMovies(getAuthorizationToken(), pageRequest.getNumber());

                final Response<TmdbTrendingMoviesResponse> response = retrofitCall.execute();

                if (response.isSuccessful()) {

                    final TmdbTrendingMoviesResponse body = response.body();

                    if (body != null) {

                        return responseConverter.convert(body);
                    }
                }

                throw exceptionConverter.convert(response.code());
            } catch (IOException e) {
                throw new HttpException(ErrorCode.UNEXPECTED_ERROR, e);
            }
        };

        return getTrendingMovies.get();
    }
}
