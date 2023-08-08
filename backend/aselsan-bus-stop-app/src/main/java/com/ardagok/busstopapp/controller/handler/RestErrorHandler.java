package com.ardagok.busstopapp.controller.handler;

import com.ardagok.busstopapp.exception.BusIdNotFoundException;
import com.ardagok.busstopapp.exception.StopIdNotFoundException;
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
    private String inCorrectBusId = "INCORRECT BUS ID ";
    private String inCorrectStopId = "INCORRECT STOP ID";

    @ExceptionHandler(BusIdNotFoundException.class)
    public final ResponseEntity<ErrorResponse> busIdNotFoundException(BusIdNotFoundException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(inCorrectBusId, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StopIdNotFoundException.class)
    public final ResponseEntity<ErrorResponse> stopIdNotFoundException(StopIdNotFoundException ex) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse error = new ErrorResponse(inCorrectStopId, details);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
