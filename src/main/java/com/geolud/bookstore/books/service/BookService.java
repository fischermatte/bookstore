package com.geolud.bookstore.books.service;

import com.geolud.bookstore.books.service.data.BookData;

public interface BookService {
    BookData findByIsbn(String isbn);
}
