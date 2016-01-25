package org.fischermatte.bookstore.inventory.domain.service;

import org.fischermatte.bookstore.inventory.domain.service.api.BookData;

import java.util.List;

public interface BookQueryService {
    List<BookData> findByTitle(String title);
}
