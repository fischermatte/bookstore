package org.fischermatte.bookstore.inventory.domain.service.impl;

import org.fischermatte.bookstore.inventory.domain.model.Book;
import org.fischermatte.bookstore.inventory.domain.repository.BookRepository;
import org.fischermatte.bookstore.inventory.domain.service.BookQueryService;
import org.fischermatte.bookstore.inventory.domain.service.api.BookData;
import org.fischermatte.bookstore.inventory.domain.service.exception.BookNotFoundException;
import org.fischermatte.bookstore.inventory.domain.service.impl.assembler.BookAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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
        if (CollectionUtils.isEmpty(books)) {
            throw new BookNotFoundException("could not find any book with title: " + title);
        }
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
