package org.fischermatte.bookstore.order.infrastructure;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = DomainEvent.EVENT_TYPE_COLUMN)
public class DomainEvent {

    public static final String EVENT_TYPE_COLUMN = "event_type";

    @EmbeddedId
    @Valid
    private DomainEventId id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = EVENT_TYPE_COLUMN)
    private DomainEventType eventType;

    @NotNull
    private boolean publishedToRemote = false;

    private DomainEvent() {
        // jpa
    }

    public DomainEvent(DomainEventType eventType) {
        this.eventType = eventType;
    }

    public DomainEventId getId() {
        return id;
    }

    public boolean isPublishedToRemote() {
        return publishedToRemote;
    }

    public void setPublishedToRemote(boolean publishedToRemote) {
        this.publishedToRemote = publishedToRemote;
    }
}
