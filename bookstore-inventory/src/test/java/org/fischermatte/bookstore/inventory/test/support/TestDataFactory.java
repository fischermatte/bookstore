package org.fischermatte.bookstore.inventory.test.support;

import org.fischermatte.bookstore.inventory.domain.model.Author;
import org.fischermatte.bookstore.inventory.domain.model.Book;
import org.springframework.stereotype.Component;

@Component
public class TestDataFactory {

    public Book createBook(String title, String isbn, String authorFirstname, String authorLastname) {
        Book book = new Book();
        book.setAuthor(createAuthor(authorFirstname, authorLastname));
        book.setTitle(title);
        book.setIsbn(isbn);
        return book;
    }

    private Author createAuthor(String firstname, String lastname) {
        return new Author(firstname, lastname);
    }
}
