package com.geolud.bookstore.service;

import com.geolud.bookstore.service.config.RestConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(RestConfig.class)
@SpringBootApplication
public class BookstoreServer {
    public static void main(String[] args) {
        SpringApplication.run(BookstoreServer.class, args);
    }

}
