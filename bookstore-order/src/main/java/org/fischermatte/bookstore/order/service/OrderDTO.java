package org.fischermatte.bookstore.order.service;

public class OrderDTO {
    private String orderId;

    private OrderDTO() {
        // needed for json mapping jackson
    }

    public OrderDTO(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }
}
