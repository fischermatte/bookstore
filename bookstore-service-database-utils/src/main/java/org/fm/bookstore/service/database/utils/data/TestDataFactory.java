package org.fm.bookstore.service.database.utils.data;

import org.fm.bookstore.service.books.domain.model.Author;
import org.fm.bookstore.service.books.domain.model.Book;

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
