package com.thortful.domain.api;

import com.thortful.domain.catalog.PageRequest;
import com.thortful.domain.catalog.TrendingMoviesPage;

public interface GetTrendingMoviesUseCase {

    TrendingMoviesPage get(PageRequest pageRequest);
}
