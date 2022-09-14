package com.kurdestanbootcamp.khanoo.commen.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String exception) {
        super(exception);
    }
}