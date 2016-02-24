package org.fischermatte.bookstore.order.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class OrderItem {

    @Id
    private UUID id;

    public UUID getId() {
        return id;
    }
}
