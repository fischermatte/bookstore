package org.fischermatte.bookstore.order.rest;

import org.fischermatte.bookstore.order.service.OrderDetailsDTO;
import org.fischermatte.bookstore.order.service.OrderSubmitCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<OrderDetailsDTO> getByOrderId(@PathVariable("orderId") String orderId) {
        return new ResponseEntity<>(new OrderDetailsDTO(orderId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> submitOrder(OrderSubmitCommand orderRequest ) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
