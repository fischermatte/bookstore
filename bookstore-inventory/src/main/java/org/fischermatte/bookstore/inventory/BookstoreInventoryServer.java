package org.fischermatte.bookstore.inventory;

import org.fischermatte.bookstore.inventory.config.RestConfig;
import org.fischermatte.bookstore.inventory.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(value = {RestConfig.class, SwaggerConfig.class})
@SpringBootApplication
public class BookstoreInventoryServer {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreInventoryServer.class, args);
    }
}
