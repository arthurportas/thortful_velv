package com.thortful.http.out.tmdb.fetchers;

import com.thortful.http.out.tmdb.TmdbApi;
import com.thortful.http.out.tmdb.TmdbApiConfiguration;
import lombok.Getter;
import retrofit2.Retrofit;

public abstract class TmdbFectherImpl implements TmdbApiConfiguration {

    @Getter
    private final TmdbApi tmdbApi;

    public TmdbFectherImpl(Retrofit.Builder retrofitBuilder) {

        this.tmdbApi = retrofitBuilder.build().create(TmdbApi.class);
    }
}
