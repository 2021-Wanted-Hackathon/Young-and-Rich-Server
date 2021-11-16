package com.hackathon.youngandrich.common.exception;

public interface ResultCode {
    int getCode();
    int getResponseCode();
    String getMessage();
    boolean equals(ResultCode other);
    boolean equals(int code);
}
