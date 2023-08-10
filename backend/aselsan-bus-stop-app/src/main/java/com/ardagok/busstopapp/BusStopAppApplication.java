package com.ardagok.busstopapp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Aselsan-Service-App",
                version = "1.0.0",
                description = "Aselsan Intern Project Arda Gök",
                contact = @Contact(
                        name = "Arda Gök",
                        email = "ardagook7@gmail.com"
                ),
                license = @License(
                        name = "License",
                        url = "ardagook"
                )
        )
)
public class BusStopAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(BusStopAppApplication.class, args);
    }
}

