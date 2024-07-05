package com.thortful.http.out.tmdb.converters;

import com.thortful.commons.utils.Converter;
import com.thortful.domain.catalog.TrendingMoviesPage;
import com.thortful.http.out.tmdb.responses.TmdbTrendingMoviesResponse;
import lombok.val;

import java.util.stream.Collectors;

public class TmdbTrendingMoviesResponseConverter implements Converter<TmdbTrendingMoviesResponse, TrendingMoviesPage> {

    private static TrendingMoviesPage.MovieDetail buildMovieDetails(final TmdbTrendingMoviesResponse.MovieDetail source) {

        return TrendingMoviesPage.MovieDetail.builder()
                .originalTitle(source.getOriginal_title())
                .build();
    }

    @Override
    public TrendingMoviesPage convert(TmdbTrendingMoviesResponse source) {

        val moviesDetailList = source.getResults().stream()
                .map(TmdbTrendingMoviesResponseConverter::buildMovieDetails)
                .collect(Collectors.toList());

        return TrendingMoviesPage.builder()
                .page(source.getPage())
                .movies(moviesDetailList)
                .build();
    }
}
