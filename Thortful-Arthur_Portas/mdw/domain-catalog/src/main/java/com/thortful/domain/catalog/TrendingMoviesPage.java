package com.thortful.domain.catalog;

import lombok.*;

import java.util.List;

@Value
@Builder(builderClassName = "Builder")
public class TrendingMoviesPage {

    int page;

    List<MovieDetail> movies;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @lombok.Builder(builderClassName = "Builder")
    public static class MovieDetail {

        String originalTitle;
    }
}
