package org.fischermatte.bookstore.order.service;

public interface OrderService {
    OrderDetailsDTO getByOrderId(String orderId);
    void submitOrder (OrderSubmitCommand orderSubmitCommand);
}
