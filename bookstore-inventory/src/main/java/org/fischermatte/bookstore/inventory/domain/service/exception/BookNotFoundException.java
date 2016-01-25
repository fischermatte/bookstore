package org.fischermatte.bookstore.inventory.domain.service.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String message) {
        super(message);
    }
}
