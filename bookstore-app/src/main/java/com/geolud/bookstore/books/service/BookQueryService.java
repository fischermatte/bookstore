package com.geolud.bookstore.books.service;

import com.geolud.bookstore.books.service.dto.BookInfoDto;

import java.util.List;

public interface BookQueryService {
    List<BookInfoDto> findByTitle(String title);
}
