package org.fischermatte.bookstore.order.infrastructure;

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

//    @NotNull
//    @Enumerated(EnumType.STRING)
//    @Column(name = EVENT_TYPE_COLUMN, nullable = false)
    @Transient
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
