package org.fischermatte.bookstore.inventory.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
public class Stock {

    @Id
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private UUID bookId;

    @NotNull
    @Column(nullable = false)
    private int quantity = 0;

    private Stock() {
        // JPA
    }

    public Stock(UUID bookId, int quantity) {
        this.id = UUID.randomUUID();
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public UUID getId() {
        return id;
    }

    public UUID getBookId() {
        return bookId;
    }

    public int getQuantity() {
        return quantity;
    }

}
