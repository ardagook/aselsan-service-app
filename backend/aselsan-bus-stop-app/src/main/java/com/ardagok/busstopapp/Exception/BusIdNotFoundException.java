package com.ardagok.busstopapp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BusIdNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public BusIdNotFoundException(String message){
        super(message);
    }
}
