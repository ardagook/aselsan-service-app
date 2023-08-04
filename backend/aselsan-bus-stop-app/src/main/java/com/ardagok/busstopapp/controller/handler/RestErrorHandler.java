package com.ardagok.busstopapp.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class RestErrorHandler extends ResponseEntityExceptionHandler {
    private String INCORRECT_BUS_ID = "INCORRECT BUS ID ";
    private String INCORRECT_STOP_ID = "INCORRECT STOP ID";

    @ExceptionHandler(BusIdNotFoundException.class)
    public final ResponseEntity<ErrorResponse> busIdNotFoundException(BusIdNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(INCORRECT_BUS_ID, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StopIdNotFoundException.class)
    public final ResponseEntity<ErrorResponse> stopIdNotFoundException(StopIdNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(INCORRECT_STOP_ID, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
