package com.geolud.bookstore.service.books.service;

import com.geolud.bookstore.service.books.service.dto.BookInfoDto;

import java.util.List;

public interface BookQueryService {
    List<BookInfoDto> findByTitle(String title);
}
