package com.thortful.rest.services.responses.converters;

import com.thortful.commons.utils.Converter;
import com.thortful.domain.catalog.TrendingMoviesPage;
import com.thortful.rest.services.responses.TrendingMoviesResponse;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TrendingMoviesResponseConverter implements Converter<TrendingMoviesPage, TrendingMoviesResponse> {

    private static TrendingMoviesResponse.MovieDetail buildMovieDetails(final TrendingMoviesPage.MovieDetail source) {

        return TrendingMoviesResponse.MovieDetail.builder()
                .originalTitle(source.getOriginalTitle())
                .build();
    }

    @Override
    public TrendingMoviesResponse convert(TrendingMoviesPage source) {

        val moviesDetailList = source.getMovies().stream()
                .map(TrendingMoviesResponseConverter::buildMovieDetails)
                .collect(Collectors.toList());

        return TrendingMoviesResponse.builder()
                .page(source.getPage())
                .results(moviesDetailList)
                .build();
    }
}
