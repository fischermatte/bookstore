package com.geolud.bookstore.books.service.impl;

import com.geolud.bookstore.books.service.BookService;
import com.geolud.bookstore.books.service.data.BookData;
import org.springframework.stereotype.Service;

@Service
public class DefaultBookService implements BookService {
    @Override
    public BookData findByIsbn(String isbn) {
        return new BookData(isbn);
    }
}
