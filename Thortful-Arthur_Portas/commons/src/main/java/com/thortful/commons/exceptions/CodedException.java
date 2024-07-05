package com.thortful.commons.exceptions;

import lombok.Getter;

@Getter
public class CodedException extends RuntimeException {

    private static final long serialVersionUID = 4225880155414423596L;

    private final ErrorCoded errorCode;

    private final String message;

    public CodedException(ErrorCoded errorCode) {

        this(errorCode, null, null);
    }

    public CodedException(ErrorCoded errorCode, Throwable e) {

        this(errorCode, e.getMessage(), e);
    }

    public CodedException(ErrorCoded errorCode, String message, Throwable e) {

        super(e);
        this.errorCode = errorCode;
        this.message = message;
    }

    public CodedException(ErrorCoded errorCode, String message) {

        this.errorCode = errorCode;
        this.message = message;
    }

    @Override
    public String getMessage() {

        if (this.message != null) {
            return String.format("%s - %s", this.errorCode, this.message);
        } else {
            return String.format("%s", this.errorCode);
        }
    }
}
