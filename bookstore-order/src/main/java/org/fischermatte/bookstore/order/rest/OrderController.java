package org.fischermatte.bookstore.order.rest;

import org.fischermatte.bookstore.order.service.OrderDetailsDTO;
import org.fischermatte.bookstore.order.service.OrderService;
import org.fischermatte.bookstore.order.service.OrderSubmitCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/{orderId}", method = RequestMethod.GET)
    public ResponseEntity<OrderDetailsDTO> getByOrderId(@PathVariable("orderId") String orderId) {
        OrderDetailsDTO orderDetails = orderService.getByOrderId(orderId);
        return new ResponseEntity<>(orderDetails, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> submitOrder(@RequestBody OrderSubmitCommand orderSubmitCommand ) {
        orderService.submitOrder(orderSubmitCommand);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
