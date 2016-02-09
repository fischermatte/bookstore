package org.fischermatte.bookstore.catalog.domain.service.impl;

import org.fischermatte.bookstore.catalog.domain.model.book.Book;
import org.fischermatte.bookstore.catalog.domain.repository.BookRepository;
import org.fischermatte.bookstore.catalog.domain.service.BookQueryService;
import org.fischermatte.bookstore.catalog.domain.service.api.BookData;
import org.fischermatte.bookstore.catalog.domain.service.exception.BookNotFoundException;
import org.fischermatte.bookstore.catalog.domain.service.impl.assembler.BookAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BookQueryServiceImpl implements BookQueryService {

    private final BookRepository bookRepository;
    private final BookAssembler bookAssembler;

    @Autowired
    public BookQueryServiceImpl(BookRepository bookRepository, BookAssembler bookAssembler) {
        this.bookRepository = bookRepository;
        this.bookAssembler = bookAssembler;
    }

    @Override
    public List<BookData> findByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        return bookAssembler.toDto(books);
    }

    @Override
    public BookData getByIsbn(String isbn) {
        Book book = bookRepository.getByIsbn(isbn);
        if (book == null) {
            throw new BookNotFoundException("could not find any book with isbn: " + isbn);
        }
        return bookAssembler.toDto(book);
    }
}
