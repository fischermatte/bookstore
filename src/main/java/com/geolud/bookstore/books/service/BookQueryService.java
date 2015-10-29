package com.geolud.bookstore.books.service;

import com.geolud.bookstore.books.service.dto.BookQueryResultDto;

public interface BookQueryService {
    /**
     *
     * @param isbn
     * @return
     * @throws com.geolud.bookstore.books.service.exception.BookNotFoundException
     */
    BookQueryResultDto findByIsbn(String isbn);
}
