package com.thortful.rest.services;

import com.thortful.domain.api.GetTrendingMoviesUseCase;
import com.thortful.domain.catalog.PageRequest;
import com.thortful.rest.commons.converters.PageRequestConverter;
import com.thortful.rest.services.requests.TrendingMoviesRequestFilter;
import com.thortful.rest.services.responses.TrendingMoviesResponse;
import com.thortful.rest.services.responses.converters.TrendingMoviesResponseConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MovieService {

    private final GetTrendingMoviesUseCase getTrendingMoviesUseCase;

    private final TrendingMoviesResponseConverter trendingMoviesResponseConverter;

    private final PageRequestConverter pageRequestConverter;

    public TrendingMoviesResponse getTrendingMovies(TrendingMoviesRequestFilter requestFilter) {

        final PageRequest pageRequest = pageRequestConverter.convert(requestFilter);

        return trendingMoviesResponseConverter.convert(
                getTrendingMoviesUseCase.get(pageRequest)
        );
    }
}
