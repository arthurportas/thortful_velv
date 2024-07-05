package com.thortful.commons.exceptions;

public interface ErrorCoded {

    int DOMAIN_BASE_CODE = 0;

    int EXTERNAL_SERVICES_BASE_CODE = 2000;

    int REST_BASE_CODE = 5000;

    int COMMONS_BASE_CODE = 100000;

    Integer getCode();

    String getName();
}
