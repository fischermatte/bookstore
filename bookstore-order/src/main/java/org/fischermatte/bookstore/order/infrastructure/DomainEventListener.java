package org.fischermatte.bookstore.order.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class DomainEventListener {

    private static final Logger logger = LoggerFactory.getLogger(DomainEventListener.class);

    private final DomainEventRepository domainEventRepository;

    @Autowired
    public DomainEventListener(DomainEventRepository domainEventRepository) {
        this.domainEventRepository = domainEventRepository;
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    private void onDomainEvent(DomainEvent event){
        logger.debug("persisting domain event {}", event);
        domainEventRepository.save(event);
    }

}
