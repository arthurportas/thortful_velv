package com.thortful.adapters.http.out.api.exceptions;

public class HttpNotFoundException extends HttpException {

    private static final long serialVersionUID = -5423265151089732638L;

    public HttpNotFoundException() {

        super(404, ErrorCode.NOT_FOUND);
    }
}
