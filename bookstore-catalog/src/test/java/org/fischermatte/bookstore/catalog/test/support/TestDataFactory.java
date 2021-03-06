package org.fischermatte.bookstore.catalog.test.support;

import org.fischermatte.bookstore.catalog.domain.Author;
import org.fischermatte.bookstore.catalog.domain.Book;
import org.springframework.stereotype.Component;

@Component
public class TestDataFactory {

    public Book createBook(String title, String isbn, String authorFirstname, String authorLastname) {
        Book book = new Book(isbn, title, createAuthor(authorFirstname, authorLastname));
        return book;
    }

    private Author createAuthor(String firstname, String lastname) {
        return new Author(firstname, lastname);
    }
}
