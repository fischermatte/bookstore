package org.fischermatte.bookstore.catalog.test.integration;

import org.fischermatte.bookstore.catalog.Application;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringBootTest(classes = {Application.class, BaseUrlConfiguration.class})
@TestPropertySource(locations="classpath:integration-test.properties")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CatalogIntegrationTest {

}
