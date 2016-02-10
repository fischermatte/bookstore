package org.fischermatte.bookstore.catalog.service;

import java.util.List;

public interface BookQueryService {
    List<BookData> findByTitle(String title);
    BookData getByIsbn(String isbn);
}
