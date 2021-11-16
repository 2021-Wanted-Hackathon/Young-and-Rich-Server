package com.hackathon.youngandrich.common.exception;

public class BadRequestException extends ResponseException {
    public BadRequestException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }

    public BadRequestException(ExceptionCode exceptionCode, String message) {
        super(exceptionCode, message);
    }

    public BadRequestException() {
        super(ExceptionCode.INVALID_REQUEST);
    }

    public BadRequestException(String message) {
        super(ExceptionCode.INVALID_REQUEST, message);
    }
}
