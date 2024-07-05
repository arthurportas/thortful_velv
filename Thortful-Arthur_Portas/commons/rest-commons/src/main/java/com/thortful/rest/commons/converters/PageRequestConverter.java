package com.thortful.rest.commons.converters;

import com.thortful.commons.utils.Converter;
import com.thortful.domain.catalog.PageRequest;
import com.thortful.rest.commons.filters.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PageRequestConverter implements Converter<Pageable, PageRequest> {

    @Override
    public PageRequest convert(Pageable source) {

        final int number = Optional.ofNullable(source.getPage()).orElse(1);

        return PageRequest.of(number);
    }
}
