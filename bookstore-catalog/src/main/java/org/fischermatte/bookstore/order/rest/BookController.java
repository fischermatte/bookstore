package org.fischermatte.bookstore.order.rest;

import org.fischermatte.bookstore.order.service.BookDTO;
import org.fischermatte.bookstore.order.service.BookQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<BookDTO>> search(@RequestParam("title") String title) {
        return new ResponseEntity<>(bookQueryService.findByTitle(title), HttpStatus.OK);
    }

    @RequestMapping(value = "/isbn/{isbn}", method = RequestMethod.GET)
    public ResponseEntity<BookDTO> getByIsbn(@PathVariable("isbn") String isbn) {
        return new ResponseEntity<>(bookQueryService.getByIsbn(isbn), HttpStatus.OK);
    }

}
