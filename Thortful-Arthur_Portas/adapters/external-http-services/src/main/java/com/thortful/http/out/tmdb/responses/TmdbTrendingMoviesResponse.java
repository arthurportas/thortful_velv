package com.thortful.http.out.tmdb.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@lombok.Builder(builderClassName = "Builder")
public class TmdbTrendingMoviesResponse {

    int page;

    List<MovieDetail> results;

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @lombok.Builder(builderClassName = "Builder")
    public static class MovieDetail {

        int id;

        String original_title;
    }
}
