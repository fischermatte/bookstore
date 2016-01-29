package org.fischermatte.bookstore.inventory.database.utils.data;

import org.fischermatte.bookstore.inventory.domain.model.Author;
import org.fischermatte.bookstore.inventory.domain.model.Book;

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