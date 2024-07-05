package com.thortful.adapters.http.out.api.exceptions;


import com.thortful.commons.exceptions.CodedException;
import com.thortful.commons.exceptions.ErrorCoded;
import lombok.Getter;

@Getter
public class HttpException extends CodedException {

    private static final long serialVersionUID = -7047725151977819489L;

    private final Integer httpCode;

    private final boolean propagateHttpStatus;

    public HttpException(ErrorCoded errorCoded) {

        this(null, errorCoded);
    }

    public HttpException(ErrorCoded errorCoded, Throwable throwable) {

        super(errorCoded, throwable);
        this.httpCode = null;
        this.propagateHttpStatus = false;
    }

    public HttpException(Integer httpCode, ErrorCoded errorCoded) {

        this(httpCode, errorCoded, false);
    }

    public HttpException(Integer httpCode, ErrorCoded errorCoded, boolean propagateHttpStatus) {

        super(errorCoded);
        this.httpCode = httpCode;
        this.propagateHttpStatus = propagateHttpStatus;
    }
}
