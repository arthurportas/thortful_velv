package com.thortful.adapters.http.out.api.exceptions;

public class HttpForbiddenException extends HttpException {

    private static final long serialVersionUID = 4964718910725910973L;

    public HttpForbiddenException() {

        super(403, ErrorCode.FORBIDDEN);
    }
}
