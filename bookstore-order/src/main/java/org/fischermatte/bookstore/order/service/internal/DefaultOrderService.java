package org.fischermatte.bookstore.order.service.internal;

import org.fischermatte.bookstore.order.domain.OrderRepository;
import org.fischermatte.bookstore.order.domain.OrderRequestSubmittedEvent;
import org.fischermatte.bookstore.order.service.OrderSubmitCommand;
import org.fischermatte.bookstore.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class DefaultOrderService implements OrderService {

    private OrderRepository orderRepository;

    @Autowired
    private ApplicationEventPublisher eventPublisher;

    @Autowired
    public DefaultOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    @Override
    public void submitOrder(OrderSubmitCommand orderSubmitCommand) {
        orderRepository.save(OrderAssembler.fromCommand(orderSubmitCommand));
        eventPublisher.publishEvent(new OrderRequestSubmittedEvent());
    }
}
