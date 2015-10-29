package com.geolud.bookstore.books.service.impl;

import com.geolud.bookstore.books.domain.repository.BookRepository;
import com.geolud.bookstore.books.service.BookService;
import com.geolud.bookstore.books.service.data.BookData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookData findByIsbn(String isbn) {
        return new BookData(isbn);
    }
}
