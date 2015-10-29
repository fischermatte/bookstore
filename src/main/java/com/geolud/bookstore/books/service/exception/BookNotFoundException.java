package com.geolud.bookstore.books.service.exception;

public class BookNotFoundException extends RuntimeException {
    private final String isbn;

    public BookNotFoundException(String isbn) {
        this.isbn = isbn;
    }
}
