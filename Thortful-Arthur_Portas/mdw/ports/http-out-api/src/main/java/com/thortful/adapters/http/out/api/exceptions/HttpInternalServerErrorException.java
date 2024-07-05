package com.thortful.adapters.http.out.api.exceptions;

public class HttpInternalServerErrorException extends HttpException {

    private static final long serialVersionUID = -8200782246375872825L;

    public HttpInternalServerErrorException() {

        super(500, ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
