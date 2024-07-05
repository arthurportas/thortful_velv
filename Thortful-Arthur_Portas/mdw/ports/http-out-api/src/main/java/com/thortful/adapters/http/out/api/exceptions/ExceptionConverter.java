package com.thortful.adapters.http.out.api.exceptions;


import com.thortful.commons.utils.Converter;

public class ExceptionConverter implements Converter<Integer, HttpException> {

    @Override
    public HttpException convert(Integer source) {

        switch (source) {
            case 400:
                return new HttpBadRequestException();

            case 401:
                return new HttpUnauthorizedException();

            case 403:
                return new HttpForbiddenException();

            case 404:
                return new HttpNotFoundException();

            case 409:
                return new HttpConflictException();

            case 500:
                return new HttpInternalServerErrorException();

            case 503:
                return new HttpServiceNotAvailableException();

            default:
                return new HttpException(source, ErrorCode.UNEXPECTED_ERROR);
        }
    }
}
