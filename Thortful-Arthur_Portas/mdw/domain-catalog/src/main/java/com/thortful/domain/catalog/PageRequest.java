package com.thortful.domain.catalog;

import lombok.Value;

@Value(staticConstructor = "of")
public class PageRequest {

    Integer number;
}
