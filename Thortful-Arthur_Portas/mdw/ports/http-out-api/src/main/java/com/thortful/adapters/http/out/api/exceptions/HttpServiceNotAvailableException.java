package com.thortful.adapters.http.out.api.exceptions;

public class HttpServiceNotAvailableException extends HttpException {

    private static final long serialVersionUID = -5898820999931497498L;

    public HttpServiceNotAvailableException() {

        super(503, ErrorCode.SERVICE_NOT_AVAILABLE);
    }
}
