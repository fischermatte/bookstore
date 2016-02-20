package org.fischermatte.bookstore.catalog.service.internal;

import org.fischermatte.bookstore.order.domain.Order;
import org.fischermatte.bookstore.catalog.service.OrderRequestDTO;

class OrderAssembler {
    public static Order fromDto(OrderRequestDTO orderRequest) {
        return new Order(orderRequest.getCustomerId());
    }
}
