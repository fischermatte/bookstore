package com.geolud.bookstore.books.service.impl;

import com.geolud.bookstore.books.domain.model.Book;
import com.geolud.bookstore.books.domain.repository.BookRepository;
import com.geolud.bookstore.books.service.BookQueryService;
import com.geolud.bookstore.books.service.dto.BookQueryResultDto;
import com.geolud.bookstore.books.service.exception.BookNotFoundException;
import com.geolud.bookstore.books.service.impl.assembler.BookQueryAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class BookQueryServiceImpl implements BookQueryService {

    private final BookRepository bookRepository;

    @Autowired
    public BookQueryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookQueryResultDto findByIsbn(String isbn) {
        Book book = bookRepository.findByIsdn(isbn);
        if (book == null){
            throw new BookNotFoundException(isbn);
        }
        return BookQueryAssembler.toDto(book);
    }
}
