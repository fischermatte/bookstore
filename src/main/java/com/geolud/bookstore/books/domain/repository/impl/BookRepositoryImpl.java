package com.geolud.bookstore.books.domain.repository.impl;

import com.geolud.bookstore.books.domain.model.Author;
import com.geolud.bookstore.books.domain.model.Book;
import com.geolud.bookstore.books.domain.repository.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public Book findByIsdn(String isbn) {
        if ("2".equals(isbn)){
            Book b = new Book();
            b.setIsbn(isbn);
            b.setAuthor(new Author("Friedrich", "Schiller"));
            return b;
        }
        return null;
    }
}
