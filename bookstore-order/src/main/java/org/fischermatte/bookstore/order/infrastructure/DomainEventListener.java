package org.fischermatte.bookstore.order.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class DomainEventListener {

    private static final Logger logger = LoggerFactory.getLogger(DomainEventListener.class);

    @PersistenceContext
    private EntityManager entityManager;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    private void onDomainEvent(DomainEvent event){
        logger.debug("persisting domain event {}", event);
        entityManager.persist(event);
    }

}
