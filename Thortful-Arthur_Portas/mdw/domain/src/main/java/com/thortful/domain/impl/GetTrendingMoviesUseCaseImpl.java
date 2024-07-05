package com.thortful.domain.impl;

import com.thortful.adapters.http.out.api.tmdb.MoviesFetcher;
import com.thortful.domain.api.GetTrendingMoviesUseCase;
import com.thortful.domain.catalog.PageRequest;
import com.thortful.domain.catalog.TrendingMoviesPage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetTrendingMoviesUseCaseImpl implements GetTrendingMoviesUseCase {

    private final MoviesFetcher moviesFetcher;

    @Override
    public TrendingMoviesPage get(PageRequest pageRequest) {

        return moviesFetcher.getTrendingMovies(pageRequest);
    }
}
