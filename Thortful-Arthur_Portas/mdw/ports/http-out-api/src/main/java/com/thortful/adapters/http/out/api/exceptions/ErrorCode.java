package com.thortful.adapters.http.out.api.exceptions;

import com.thortful.commons.exceptions.ErrorCoded;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ErrorCode implements ErrorCoded {
    UNMAPPED_CAPABILITY(1),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    CONFLICT(409),
    INTERNAL_SERVER_ERROR(500),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    SERVICE_NOT_AVAILABLE(503),
    GATEWAY_TIMEOUT(504),
    UNEXPECTED_ERROR(0);

    private final Integer code;

    @Override
    public Integer getCode() {

        return ErrorCoded.EXTERNAL_SERVICES_BASE_CODE + this.code;
    }

    @Override
    public String getName() {

        return this.name();
    }
}
