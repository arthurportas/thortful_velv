package com.thortful.rest.services.responses;


import lombok.*;

import java.util.List;

@Getter
@Builder(builderClassName = "Builder")
public class TrendingMoviesResponse {

    int page;

    List<MovieDetail> results;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @lombok.Builder(builderClassName = "Builder")
    public static class MovieDetail {

        String originalTitle;
    }
}
