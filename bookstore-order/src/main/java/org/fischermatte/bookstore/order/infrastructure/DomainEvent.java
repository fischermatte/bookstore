package org.fischermatte.bookstore.order.infrastructure;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

// TODO make table name work with Uppercase and use propper naming strategy
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Table(name="DOMAIN_EVENT")
public class DomainEvent {

    @EmbeddedId
    @Valid
    private DomainEventId id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private DomainEventType eventType;

    @NotNull
    @Column(nullable = false)
    private Boolean publishedToRemote = Boolean.FALSE;

    protected DomainEvent() {
        // jpa
    }

    public DomainEvent(DomainEventType eventType) {
        this.eventType = eventType;
        this.id = new DomainEventId();
    }

    public DomainEventId getId() {
        return id;
    }

    public Boolean getPublishedToRemote() {
        return publishedToRemote;
    }

    public DomainEventType getEventType() {
        return eventType;
    }

    public void updatePublishedToRemote() {
        this.publishedToRemote = true;
    }
}
