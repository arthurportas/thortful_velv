package com.thortful.adapters.http.out.api.exceptions;

public class HttpConflictException extends HttpException {

    private static final long serialVersionUID = -5423265151089732638L;

    public HttpConflictException() {

        super(409, ErrorCode.CONFLICT, true);
    }
}
