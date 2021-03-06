package org.fischermatte.bookstore.order.infrastructure;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

@Embeddable
public class DomainEventId implements Serializable {

    @NotNull
    @Column(name = "domain_event_id", nullable = false)
    private UUID id;

    public DomainEventId() {
        this.id = UUID.randomUUID();
    }

    public DomainEventId(UUID id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DomainEventId that = (DomainEventId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
