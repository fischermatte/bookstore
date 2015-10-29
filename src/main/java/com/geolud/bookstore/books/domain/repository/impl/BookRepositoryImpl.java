package com.geolud.bookstore.books.domain.repository.impl;

import com.geolud.bookstore.books.domain.model.Book;
import com.geolud.bookstore.books.domain.repository.BookRepository;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public Book findByIsdn(String isdn) {
        return null;
    }
}
