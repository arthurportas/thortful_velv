package com.thortful.rest.services.requests;

import com.thortful.rest.commons.filters.Pageable;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Builder(builderClassName = "Builder")
@RequiredArgsConstructor
@Value
public class TrendingMoviesRequestFilter implements Pageable {

    @Max(value = 1000)
    @Min(value = 0)
    Integer page;
}
