package com.thortful.http.out.fakers;

import com.github.javafaker.Faker;
import com.thortful.domain.catalog.PageRequest;
import com.thortful.domain.catalog.TrendingMoviesPage;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@NoArgsConstructor
public class DomainFaker {

    private final Faker faker = new Faker();

    public TrendingMoviesPage.Builder trendingMoviesPage() {

        return TrendingMoviesPage.builder()
                .page(faker.number().randomDigit())
                .movies(List.of(
                        movieDetail().build(),
                        movieDetail().build()
                ));
    }

    public TrendingMoviesPage.MovieDetail.Builder movieDetail() {

        return TrendingMoviesPage.MovieDetail.builder()
                .originalTitle(faker.funnyName().name());
    }

    public PageRequest pageRequest() {

        return PageRequest.of(faker.number().randomDigit());
    }

    private <T> T randomChoice(Iterator<T> values) {

        final List<T> list = StreamSupport.stream(Spliterators.spliteratorUnknownSize(values, Spliterator.ORDERED), false)
                .collect(Collectors.toUnmodifiableList());

        return list.get(faker.random().nextInt(list.size()));
    }

    @SafeVarargs
    private <T> T randomChoice(T... values) {

        return values[faker.random().nextInt(values.length)];
    }

    private UUID uuid() {

        return UUID.randomUUID();
    }
}
