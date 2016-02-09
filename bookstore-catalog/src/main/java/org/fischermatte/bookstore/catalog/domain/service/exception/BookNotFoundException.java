package org.fischermatte.bookstore.catalog.domain.service.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}
