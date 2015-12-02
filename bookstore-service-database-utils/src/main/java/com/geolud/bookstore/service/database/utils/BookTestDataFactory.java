package com.geolud.bookstore.service.database.utils;

import com.geolud.bookstore.service.books.domain.model.Book;
import com.geolud.bookstore.service.books.domain.repository.BookRepository;
import com.geolud.bookstore.service.books.domain.model.Author;

public class BookTestDataFactory {

    private final BookRepository bookRepository;

    public BookTestDataFactory(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void insertData(){
        Book book = new Book();
        book.setAuthor(new Author("Bertold", "Brecht"));
        book.setTitle("3 Groschenoper");
        bookRepository.save(book);
    }
}
