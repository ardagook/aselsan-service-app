package com.ardagok.busstopapp.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StopIdNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public StopIdNotFoundException(String message){
        super(message);
    }
}