package org.fischermatte.bookstore.catalog;

import org.fischermatte.bookstore.catalog.config.RestConfig;
import org.fischermatte.bookstore.catalog.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(value = {RestConfig.class, SwaggerConfig.class})
@SpringBootApplication
public class BookstoreCatalogServer {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreCatalogServer.class, args);
    }
}
