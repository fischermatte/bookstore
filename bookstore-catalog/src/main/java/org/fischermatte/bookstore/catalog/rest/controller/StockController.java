package org.fischermatte.bookstore.catalog.rest.controller;

import org.fischermatte.bookstore.catalog.service.StockData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @RequestMapping(value = "/isbn/{isbn}", method = RequestMethod.GET)
    public ResponseEntity<StockData> getByIsbn(@PathVariable("isbn") String isbn) {
        return new ResponseEntity<>(new StockData(), HttpStatus.OK);
    }

}
