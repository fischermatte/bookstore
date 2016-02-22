package org.fischermatte.bookstore.order.service.internal;

import org.fischermatte.bookstore.order.domain.Order;
import org.fischermatte.bookstore.order.service.OrderSubmitCommand;

class OrderAssembler {
    public static Order fromCommand(OrderSubmitCommand orderRequest) {
        return new Order(orderRequest.getCustomerId());
    }
}
