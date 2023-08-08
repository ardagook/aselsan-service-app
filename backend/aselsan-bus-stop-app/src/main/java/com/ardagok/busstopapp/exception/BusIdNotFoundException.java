package com.ardagok.busstopapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BusIdNotFoundException extends RuntimeException{
    public BusIdNotFoundException(String message){
        super(message);
    }
}
