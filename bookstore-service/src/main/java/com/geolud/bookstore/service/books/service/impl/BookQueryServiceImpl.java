package com.geolud.bookstore.service.books.service.impl;

import com.geolud.bookstore.service.books.domain.model.Book;
import com.geolud.bookstore.service.books.domain.repository.BookRepository;
import com.geolud.bookstore.service.books.service.BookQueryService;
import com.geolud.bookstore.service.books.service.dto.BookInfoDto;
import com.geolud.bookstore.service.books.service.exception.BookNotFoundException;
import com.geolud.bookstore.service.books.service.impl.assembler.BookAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class BookQueryServiceImpl implements BookQueryService {

    private final BookRepository bookRepository;

    @Autowired
    public BookQueryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookInfoDto> findByTitle(String title) {
        List<Book> books = bookRepository.findByTitle(title);
        if (books == null){
            throw new BookNotFoundException("could not find book with title: " + title);
        }
        return BookAssembler.toDto(books);
    }
}