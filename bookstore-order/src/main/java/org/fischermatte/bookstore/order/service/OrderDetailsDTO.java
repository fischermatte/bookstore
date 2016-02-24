package org.fischermatte.bookstore.order.service;

public class OrderDetailsDTO {

    private String orderId;

    private OrderDetailsDTO() {
        // needed for json mapping jackson
    }

    public OrderDetailsDTO(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
