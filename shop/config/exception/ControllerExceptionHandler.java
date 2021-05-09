package com.teodoralashes.shop.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({EntityExistsException.class})
    @ResponseStatus(value = HttpStatus.CONFLICT)
    public @ResponseBody
    ExceptionResponse handleConflict(final RuntimeException exc,
                                       final HttpServletRequest request) {
        String status = HttpStatus.CONFLICT.toString();

        return new ExceptionResponse(exc.getMessage(), request.getRequestURI(), status.split(" ")[0],
                status.split(" ")[1]);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public @ResponseBody
    ExceptionResponse handleNotFound(final RuntimeException exc,
                                       final HttpServletRequest request) {
        String status = HttpStatus.NOT_FOUND.toString();

        return new ExceptionResponse(exc.getMessage(), request.getRequestURI(), status.split(" ")[0],
                status.split(" ")[1]);
    }

}
