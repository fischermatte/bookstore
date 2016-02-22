package org.fischermatte.bookstore.order.domain;

import org.fischermatte.bookstore.order.infrastructure.DomainEvent;
import org.fischermatte.bookstore.order.infrastructure.DomainEventType;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.UUID;

// TODO define foreignkey name to DomainEvent in Hibernate (bug, stackoverflow?)
// @PrimaryKeyJoinColumn(foreignKey = @ForeignKey(name = "FK_DOMAIN_EVENT_ID"))
@Entity
public class OrderSubmittedEvent extends DomainEvent {
    @NotNull
    private UUID orderId;

    @NotBlank
    @Length(max = 255)
    @Column(nullable = false, length = 255)
    private String customerId;

    protected OrderSubmittedEvent() {
        super(DomainEventType.ORDER_SUBMITTED);
        // jpa
    }

    public OrderSubmittedEvent(UUID orderId, String customerId) {
        super(DomainEventType.ORDER_SUBMITTED);
        this.orderId = orderId;
        this.customerId = customerId;
    }
}
