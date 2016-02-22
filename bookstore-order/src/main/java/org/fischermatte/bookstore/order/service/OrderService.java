package org.fischermatte.bookstore.order.service;

public interface OrderService {
    void submitOrder (OrderSubmitCommand orderSubmitCommand);
}
