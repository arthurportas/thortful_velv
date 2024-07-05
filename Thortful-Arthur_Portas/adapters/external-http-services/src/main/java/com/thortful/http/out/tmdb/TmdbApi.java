package com.thortful.http.out.tmdb;


import com.thortful.http.out.tmdb.responses.TmdbTrendingMoviesResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface TmdbApi {

    @Headers({
            "Accept: application/json"
    })
    @GET("/3/trending/movie/day?language=en-US")
    Call<TmdbTrendingMoviesResponse> getTrendingMovies(@Header("Authorization") String authorizationToken, @Query("page") Integer page);
}