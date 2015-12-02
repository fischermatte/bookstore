package com.geolud.bookstore.service.rest.controller;

import com.geolud.bookstore.service.books.service.BookQueryService;
import com.geolud.bookstore.service.books.service.dto.BookInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    private final BookQueryService bookQueryService;

    @Autowired
    public BookController(BookQueryService bookQueryService) {
        this.bookQueryService = bookQueryService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseEntity<List<BookInfoDto>> search(@RequestParam("title") String title) {
        return new ResponseEntity<>(bookQueryService.findByTitle(title), HttpStatus.OK);
    }
}
