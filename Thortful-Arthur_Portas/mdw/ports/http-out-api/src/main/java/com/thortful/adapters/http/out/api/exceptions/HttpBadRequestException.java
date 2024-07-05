package com.thortful.adapters.http.out.api.exceptions;

public class HttpBadRequestException extends HttpException {

    private static final long serialVersionUID = -3388760914951547429L;

    public HttpBadRequestException() {

        super(400, ErrorCode.BAD_REQUEST);
    }

    public HttpBadRequestException(boolean propagateHttpStatus) {

        super(400, ErrorCode.BAD_REQUEST, propagateHttpStatus);
    }
}
