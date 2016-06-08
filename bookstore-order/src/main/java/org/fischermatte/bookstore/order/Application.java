package org.fischermatte.bookstore.order;

import org.fischermatte.bookstore.order.config.RestConfig;
import org.fischermatte.bookstore.order.config.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(value = {RestConfig.class, SwaggerConfig.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
