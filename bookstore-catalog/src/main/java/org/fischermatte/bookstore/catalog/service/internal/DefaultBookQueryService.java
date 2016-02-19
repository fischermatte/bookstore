package org.fischermatte.bookstore.catalog.service.internal;

import org.fischermatte.bookstore.catalog.domain.Book;
import org.fischermatte.bookstore.catalog.domain.BookRepository;
import org.fischermatte.bookstore.catalog.service.BookDTO;
import org.fischermatte.bookstore.catalog.service.BookNotFoundException;
import org.fischermatte.bookstore.catalog.service.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DefaultBookQueryService implements BookQueryService {

    private final BookRepository bookRepository;
    private final BookAssembler bookAssembler;

    @Autowired
    public DefaultBookQueryService(BookRepository bookRepository, BookAssembler bookAssembler) {
        this.bookRepository = bookRepository;
        this.bookAssembler = bookAssembler;
    }

    @Override
    public List<BookDTO> findByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        return bookAssembler.toDto(books);
    }

    @Override
    public BookDTO getByIsbn(String isbn) {
        Book book = bookRepository.getByIsbn(isbn);
        if (book == null) {
            throw new BookNotFoundException("could not find any book with isbn: " + isbn);
        }
        return bookAssembler.toDto(book);
    }
}
