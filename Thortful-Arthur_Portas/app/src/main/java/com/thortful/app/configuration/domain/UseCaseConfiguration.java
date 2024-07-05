package com.thortful.app.configuration.domain;

import com.thortful.adapters.http.out.api.tmdb.MoviesFetcher;
import com.thortful.domain.api.GetTrendingMoviesUseCase;
import com.thortful.domain.impl.GetTrendingMoviesUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    @Bean
    GetTrendingMoviesUseCase getTrendingMoviesUseCase(MoviesFetcher moviesFetcher) {
        return new GetTrendingMoviesUseCaseImpl(moviesFetcher);
    }
}
