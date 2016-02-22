package org.fischermatte.bookstore.order.service.internal;

import org.fischermatte.bookstore.order.domain.OrderRepository;
import org.fischermatte.bookstore.order.domain.OrderSubmittedEvent;
import org.fischermatte.bookstore.order.service.OrderService;
import org.fischermatte.bookstore.order.service.OrderSubmitCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class DefaultOrderService implements OrderService {

    private final OrderRepository orderRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Autowired
    DefaultOrderService(OrderRepository orderRepository, ApplicationEventPublisher eventPublisher) {
        this.orderRepository = orderRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    @Override
    public void submitOrder(OrderSubmitCommand orderSubmitCommand) {
        orderRepository.save(OrderAssembler.fromCommand(orderSubmitCommand));
        eventPublisher.publishEvent(new OrderSubmittedEvent());
    }
}
