package com.geolud.bookstore.books.domain.repository;

import com.geolud.bookstore.books.domain.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> findByTitle(String isbn);
}
