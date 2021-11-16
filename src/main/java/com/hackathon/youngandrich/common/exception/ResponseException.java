package com.hackathon.youngandrich.common.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class ResponseException extends RuntimeException {

    protected ExceptionCode exceptionCode = ExceptionCode.INTERNAL_SERVER_ERROR;
    protected  String[] args;

    protected ResponseException(ExceptionCode exceptionCode) {
        this(exceptionCode, exceptionCode.getMessage());
    }

    protected ResponseException(ExceptionCode exceptionCode, String[] args) {
        this(exceptionCode, exceptionCode.getMessage(), args);
    }

    protected ResponseException(ExceptionCode exceptionCode, String message) {
        super(message);
        this.exceptionCode = exceptionCode;
    }

    protected ResponseException(ExceptionCode exceptionCode, String message, String[] args) {
        super(message);
        this.exceptionCode = exceptionCode;
        this.args = args;
    }

    public ExceptionCode getExceptionCode() {
        return exceptionCode;
    }

    public String[] getArgs() {
        return args;
    }
}
