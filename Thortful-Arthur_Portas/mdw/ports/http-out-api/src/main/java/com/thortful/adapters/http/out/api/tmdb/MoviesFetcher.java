package com.thortful.adapters.http.out.api.tmdb;

import com.thortful.domain.catalog.PageRequest;
import com.thortful.domain.catalog.TrendingMoviesPage;

public interface MoviesFetcher {

    TrendingMoviesPage getTrendingMovies(PageRequest pageRequest);
}
