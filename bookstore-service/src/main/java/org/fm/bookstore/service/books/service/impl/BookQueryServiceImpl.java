package org.fm.bookstore.service.books.service.impl;

import org.fm.bookstore.service.books.domain.model.Book;
import org.fm.bookstore.service.books.domain.repository.BookRepository;
import org.fm.bookstore.service.books.service.BookQueryService;
import org.fm.bookstore.service.books.service.api.BookData;
import org.fm.bookstore.service.books.service.exception.BookNotFoundException;
import org.fm.bookstore.service.books.service.impl.assembler.BookAssembler;
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
        List<Book> books = bookRepository.searchByTitle(title);
        if (books == null){
            throw new BookNotFoundException("could not find book with title: " + title);
        }
        return bookAssembler.toDto(books);
    }
}
