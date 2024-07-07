package com.thortful.rest.services.requests.converters;

import com.thortful.domain.catalog.TrendingMoviesPage;
import com.thortful.rest.fakers.DomainFaker;
import com.thortful.rest.services.responses.TrendingMoviesResponse;
import com.thortful.rest.services.responses.converters.TrendingMoviesResponseConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TrendingMoviesResponseConverterTest {

    private final DomainFaker domainFaker = new DomainFaker();

    private final TrendingMoviesResponseConverter converter = new TrendingMoviesResponseConverter();

    @Test
    void convert_whenTrendingMoviesPage_returnsTrendingMoviesResponse() {

        //Given
        final TrendingMoviesPage source = domainFaker.trendingMoviesPage().build();

        //When
        final TrendingMoviesResponse converted = converter.convert(source);

        //Then
        final TrendingMoviesResponse result = TrendingMoviesResponse.builder()
                .page(source.getPage())
                .results(source.getMovies().stream()
                        .map(m -> TrendingMoviesResponse.MovieDetail.builder()
                                .originalTitle(m.getOriginalTitle())
                                .build()).collect(Collectors.toList()))
                .build();
        assertThat(converted).isEqualToComparingFieldByFieldRecursively(result);
    }
}
