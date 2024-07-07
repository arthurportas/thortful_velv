package com.thortful.rest.services;

import com.thortful.domain.api.GetTrendingMoviesUseCase;
import com.thortful.domain.catalog.PageRequest;
import com.thortful.domain.catalog.TrendingMoviesPage;
import com.thortful.rest.commons.converters.PageRequestConverter;
import com.thortful.rest.fakers.DomainFaker;
import com.thortful.rest.services.requests.TrendingMoviesRequestFilter;
import com.thortful.rest.services.responses.TrendingMoviesResponse;
import com.thortful.rest.services.responses.converters.TrendingMoviesResponseConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MovieServiceTest {

    private final DomainFaker domainFaker = new DomainFaker();

    @InjectMocks
    private MovieService movieService;

    @Mock
    private GetTrendingMoviesUseCase getTrendingMoviesUseCase;

    @Mock
    private TrendingMoviesResponseConverter trendingMoviesResponseConverter;

    @Mock
    private PageRequestConverter pageRequestConverter;

    @Test
    void getTrendingMovies_whenThereIsATrendingMoviesPage_thenReturnsTrendingMoviesResponse() {

        // Given
        final TrendingMoviesRequestFilter source = domainFaker.trendingMoviesRequestFilter().build();

        final PageRequest pageRequest = domainFaker.pageRequest();

        final TrendingMoviesPage resultOfUseCase = domainFaker.trendingMoviesPage().build();

        final TrendingMoviesResponse resultOfService = TrendingMoviesResponse.builder()
                .page(pageRequest.getNumber())
                .results(resultOfUseCase.getMovies().stream()
                        .map(m -> TrendingMoviesResponse.MovieDetail.builder()
                                .originalTitle(m.getOriginalTitle())
                                .build()).collect(Collectors.toList()))
                .build();

        doReturn(pageRequest).when(pageRequestConverter).convert(source);
        doReturn(resultOfUseCase).when(getTrendingMoviesUseCase).get(pageRequest);
        doReturn(resultOfService).when(trendingMoviesResponseConverter).convert(resultOfUseCase);

        // When
        final TrendingMoviesResponse processed = movieService.getTrendingMovies(source);

        // Then
        assertThat(processed).isEqualToComparingFieldByFieldRecursively(resultOfService);
    }
}
