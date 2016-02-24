package org.fischermatte.bookstore.inventory.rest;

import org.fischermatte.bookstore.inventory.service.StockDTO;
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
    public ResponseEntity<StockDTO> getByIsbn(@PathVariable("isbn") String isbn) {
        return new ResponseEntity<>(new StockDTO(), HttpStatus.OK);
    }

}
