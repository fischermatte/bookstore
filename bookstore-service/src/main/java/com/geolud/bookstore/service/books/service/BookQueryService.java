package com.geolud.bookstore.service.books.service;

import com.geolud.bookstore.service.books.service.api.BookData;

import java.util.List;

public interface BookQueryService {
    List<BookData> findByTitle(String title);
}
