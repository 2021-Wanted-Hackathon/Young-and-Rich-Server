package com.hackathon.youngandrich.common.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

import com.hackathon.youngandrich.common.exception.ExceptionCode;
import com.hackathon.youngandrich.common.exception.ResponseException;
import com.hackathon.youngandrich.common.model.ErrorResult;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.core.JsonParseException;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice(basePackages = "com.hackathon.youngandrich")
public class ControllerAdvice {


    @ExceptionHandler(ResponseException.class)
    public ErrorResult handleResponseException(HttpServletRequest req, HttpServletResponse res, ResponseException exception) {
        log.warn(exception.toString(), exception);
        res.setStatus(exception.getExceptionCode().getCode());
        return makeErrorResult(exception.getExceptionCode());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({
            HttpMessageNotReadableException.class,
            ConstraintViolationException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class,
            MethodArgumentNotValidException.class,
    })
    public ErrorResult handleBadRequestException(HttpServletRequest req, Exception exception) {
        log.warn(exception.toString(), exception);
        return makeErrorResult(ExceptionCode.INVALID_REQUEST);
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ErrorResult handleMethodNotAllowedException(HttpServletRequest req, HttpRequestMethodNotSupportedException exception) {
        log.warn(exception.toString(), exception);
        return makeErrorResult(ExceptionCode.NOT_ALLOWED_METHOD);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErrorResult handleIllegalArgumentException(HttpServletRequest req, IllegalArgumentException exception) {
        log.warn(exception.toString(), exception);
        return makeErrorResult(ExceptionCode.INVALID_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoHandlerFoundException.class)
    public ErrorResult handleNotFoundException(HttpServletRequest req, NoHandlerFoundException exception) {
        log.warn(exception.toString(), exception);
        return makeErrorResult(ExceptionCode.NOT_FOUND_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ErrorResult handleInternalServerException(HttpServletRequest req, Exception exception) {
        log.warn(exception.toString(), exception);
        return makeErrorResult(ExceptionCode.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorResult handleException(HttpServletRequest req, Exception exception) {
        log.warn(exception.toString(), exception);
        return makeErrorResult(ExceptionCode.INTERNAL_SERVER_ERROR);
    }

    private ErrorResult makeErrorResult(ExceptionCode errorCode) {
        return new ErrorResult(errorCode);
    }


}
