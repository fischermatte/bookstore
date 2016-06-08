package org.fischermatte.bookstore.order.database.utils.schema;

import org.springframework.boot.SpringApplication;

public class SchemaGenerator {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(org.fischermatte.bookstore.catalog.Application.class, new String[]{"--spring.config.name=schema-generator", "--schema=catalog"}).close();
        SpringApplication.run(org.fischermatte.bookstore.inventory.Application.class, new String[]{"--spring.config.name=schema-generator", "--schema=inventory"}).close();
        SpringApplication.run(org.fischermatte.bookstore.order.Application.class, new String[]{"--spring.config.name=schema-generator", "--schema=order"}).close();
    }


}

