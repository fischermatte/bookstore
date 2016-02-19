package org.fischermatte.bookstore.order.service;

import java.util.List;

public interface BookQueryService {
    List<BookDTO> findByTitle(String title);
    BookDTO getByIsbn(String isbn);
}
