package org.fischermatte.bookstore.order.database.utils.data;


import org.fischermatte.bookstore.catalog.domain.Author;
import org.fischermatte.bookstore.catalog.domain.Book;

public class TestDataFactory {

    public Book createBook(String title, String isbn, Author author){
        Book book = new Book(isbn, title, author);
        return book;
    }

    public Author createAuthor(String firstname, String lastname){
        return new Author(firstname, lastname);
    }
}
