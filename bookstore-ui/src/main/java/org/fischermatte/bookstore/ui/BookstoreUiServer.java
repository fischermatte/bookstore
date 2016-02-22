package org.fischermatte.bookstore.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class BookstoreUiServer {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreUiServer.class, args);
	}


}
