package com.thortful.rest.fakers;

import com.thortful.rest.fakers.BaseFaker;
import com.thortful.rest.services.responses.TrendingMoviesResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class ExternalServicesFaker extends BaseFaker {

    public TrendingMoviesResponse.Builder trendingMoviesResponse() {
        return null;
    }

    public UUID sid() {

        return UUID.randomUUID();
    }
}
