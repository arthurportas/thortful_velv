package com.thortful.adapters.http.out.api.exceptions;

public class HttpUnauthorizedException extends HttpException {

    private static final long serialVersionUID = -3896116032459793030L;

    public HttpUnauthorizedException() {

        super(401, ErrorCode.UNAUTHORIZED);
    }
}
