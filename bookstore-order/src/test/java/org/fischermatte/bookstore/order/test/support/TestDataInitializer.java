package org.fischermatte.bookstore.order.test.support;

import org.fischermatte.bookstore.order.domain.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer {

    private final OrderRepository orderRepository;
    private final TestDataFactory bookFactory;

    @Autowired
    public TestDataInitializer(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
        this.bookFactory = new TestDataFactory();
    }
}
