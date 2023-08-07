package com.ardagok.busstopapp.controller.handler;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class ErrorResponse {
    private String kod;
    private List<String> message;
    public ErrorResponse(String kod, List<String> message) {
        super();
        this.kod = kod;
        this.message = message;
    }
}
