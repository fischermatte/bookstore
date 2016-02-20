package org.fischermatte.bookstore.catalog.service.internal;

import org.fischermatte.bookstore.order.domain.OrderRepository;
import org.fischermatte.bookstore.catalog.service.OrderRequestDTO;
import org.fischermatte.bookstore.catalog.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class DefaultOrderService implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    public DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    @Override
    public void submitOrder(OrderRequestDTO orderRequest) {
        orderRepository.save(OrderAssembler.fromDto(orderRequest));
    }
}
