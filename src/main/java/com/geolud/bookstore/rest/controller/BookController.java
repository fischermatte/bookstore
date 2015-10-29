package com.geolud.bookstore.rest.controller;

import com.geolud.bookstore.books.service.BookQueryService;
import com.geolud.bookstore.books.service.dto.BookQueryResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/book")
public class BookController {

    private final BookQueryService bookQueryService;

    @Autowired
    public BookController(BookQueryService bookQueryService) {
        this.bookQueryService = bookQueryService;
    }

    @RequestMapping(value = "/isbn/{isbn}")
    public ResponseEntity<BookQueryResultDto> getBook(@PathVariable String isbn) {
        return new ResponseEntity<>(bookQueryService.findByIsbn(isbn), HttpStatus.OK);
    }
}
