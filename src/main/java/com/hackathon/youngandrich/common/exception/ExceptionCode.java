package com.hackathon.youngandrich.common.exception;

import org.springframework.http.HttpStatus;

public enum ExceptionCode implements ResultCode {
    SUCCESS(HttpStatus.OK),
    NOT_ALLOWED_METHOD(HttpStatus.METHOD_NOT_ALLOWED, HttpStatus.METHOD_NOT_ALLOWED.value(), "Method not allowed"),
    INVALID_REQUEST(HttpStatus.BAD_REQUEST, 1001, "Invalid request"),
    NOT_FOUND_REQUEST(HttpStatus.NOT_FOUND, 1004, "Not Found requested"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 1999, "Internal Server Error"),

    // User
    ALREADY_EXIST_EMAIL(HttpStatus.BAD_REQUEST, 2001, "Already exist email"),
    ALREADY_EXIST_PHONENUMBER(HttpStatus.BAD_REQUEST, 2002, "Already exist phone number");

    private final int httpCode;
    private final int responseCode;
    private final String message;

    ExceptionCode(HttpStatus httpStatus) {
        this.httpCode = httpStatus.value();
        this.responseCode = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
    }

    ExceptionCode(HttpStatus httpStatus, int responseCode, String message) {
        this.httpCode = httpStatus.value();
        this.responseCode = responseCode;
        this.message = message;
    }

    @Override
    public int getCode() {
        return httpCode;
    }

    @Override
    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean equals(ResultCode other) {
        if (this == other) {
            return true;
        }
        return responseCode == other.getResponseCode();
    }

    @Override
    public boolean equals(int responseCode) {
        return this.responseCode == responseCode;
    }

}
