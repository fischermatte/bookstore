package org.fischermatte.bookstore.catalog.service;

import org.fischermatte.bookstore.catalog.service.api.BookData;

import java.util.List;

public interface BookQueryService {
    List<BookData> findByTitle(String title);
    BookData getByIsbn(String isbn);
}
