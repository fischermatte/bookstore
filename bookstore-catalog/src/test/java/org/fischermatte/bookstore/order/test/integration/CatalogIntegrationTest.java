package org.fischermatte.bookstore.order.test.integration;

import org.fischermatte.bookstore.order.BookstoreCatalogServer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.TestPropertySource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringApplicationConfiguration(classes = BookstoreCatalogServer.class)
@WebIntegrationTest
@TestPropertySource(locations="classpath:integration-test.properties")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface CatalogIntegrationTest {

}
