package com.hackathon.youngandrich.common.exception;

public class InternalServerException extends ResponseException {
    public InternalServerException() {
        super(ExceptionCode.INTERNAL_SERVER_ERROR);
    }
    public InternalServerException(String message) {
        super(ExceptionCode.INTERNAL_SERVER_ERROR, message);
    }
}
