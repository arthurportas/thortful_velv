package com.thortful.commons.exceptions;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode implements ErrorCoded {

    NOT_IMPLEMENTED(0),
    ;

    private final Integer code;

    @Override
    public Integer getCode() {

        return ErrorCoded.COMMONS_BASE_CODE + this.code;
    }

    @Override
    public String getName() {

        return this.name();
    }
}
