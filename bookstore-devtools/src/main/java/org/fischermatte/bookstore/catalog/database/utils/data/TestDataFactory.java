package org.fischermatte.bookstore.catalog.database.utils.data;

import org.fischermatte.bookstore.catalog.domain.book.Author;
import org.fischermatte.bookstore.catalog.domain.book.Book;

public class TestDataFactory {

    public Book createBook(String title, String isbn, Author author){
        Book book = new Book();
        book.setAuthor(author);
        book.setTitle(title);
        book.setIsbn(isbn);
        return book;
    }

    public Author createAuthor(String firstname, String lastname){
        return new Author(firstname, lastname);
    }
}
