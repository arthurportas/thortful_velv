package com.thortful.rest.controllers;

import com.thortful.rest.RestConstants;
import com.thortful.rest.services.MovieService;
import com.thortful.rest.services.requests.TrendingMoviesRequestFilter;
import com.thortful.rest.services.responses.TrendingMoviesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping(RestConstants.API_ENDPOINT)
@RestController
public class MovieController {

    private final MovieService movieService;

    @GetMapping(path = "/trending/movies")
    public TrendingMoviesResponse getTrendingMovies(
            @Valid TrendingMoviesRequestFilter requestFilter
    ) {

        return movieService.getTrendingMovies(requestFilter);
    }
}
