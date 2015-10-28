package com.geolud.bookstore.books.service;

import com.geolud.bookstore.books.data.BookData;

public interface BookService {
    BookData findByIsbn(String isbn);
}
