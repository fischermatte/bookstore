package com.geolud.bookstore.service.test;

import com.geolud.bookstore.service.BookstoreServer;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.TestPropertySource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@SpringApplicationConfiguration(classes = BookstoreServer.class)
@WebIntegrationTest
@TestPropertySource(locations="classpath:application-test.properties")
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BookstoreIntegrationTest {

}
