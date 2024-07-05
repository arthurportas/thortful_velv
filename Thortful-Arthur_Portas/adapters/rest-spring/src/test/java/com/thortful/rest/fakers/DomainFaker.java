package com.thortful.rest.fakers;

import com.thortful.domain.catalog.PageRequest;
import com.thortful.domain.catalog.TrendingMoviesPage;
import com.thortful.rest.services.requests.TrendingMoviesRequestFilter;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
public class DomainFaker {

    private final BaseFaker baseFaker = new BaseFaker();

    public TrendingMoviesPage.Builder trendingMoviesPage() {

        return TrendingMoviesPage.builder()
                .page(baseFaker.faker.number().randomDigit())
                .movies(List.of(
                        movieDetail().build(),
                        movieDetail().build()
                ));
    }

    public TrendingMoviesPage.MovieDetail.Builder movieDetail() {

        return TrendingMoviesPage.MovieDetail.builder()
                .originalTitle(baseFaker.faker.funnyName().name());
    }

    public TrendingMoviesRequestFilter.Builder trendingMoviesRequestFilter() {

        return TrendingMoviesRequestFilter.builder()
                .page(baseFaker.faker.number().randomDigit());

    }

    public PageRequest pageRequest() {

        return PageRequest.of(baseFaker.faker.number().randomDigit());
    }

    private <T> T randomChoice(Iterator<T> values) {

        final List<T> list = StreamSupport.stream(Spliterators.spliteratorUnknownSize(values, Spliterator.ORDERED), false)
                .collect(Collectors.toUnmodifiableList());

        return list.get(baseFaker.faker.random().nextInt(list.size()));
    }

    @SafeVarargs
    private <T> T randomChoice(T... values) {

        return values[baseFaker.faker.random().nextInt(values.length)];
    }

    private UUID uuid() {

        return UUID.randomUUID();
    }
}
