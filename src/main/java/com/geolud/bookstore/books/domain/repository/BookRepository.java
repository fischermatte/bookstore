package com.geolud.bookstore.books.domain.repository;

import com.geolud.bookstore.books.domain.model.Book;

public interface BookRepository {
    Book findByIsdn(String isbn);
}
