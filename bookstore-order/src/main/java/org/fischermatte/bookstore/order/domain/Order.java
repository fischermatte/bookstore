package org.fischermatte.bookstore.order.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

// TODO make table name work with Uppercase.
@Entity
@Table(name="\"order\"")  // quotes since order is reserved
public class Order {
    @Id
    private UUID id;

    @NotBlank
    @Length(max = 255)
    @Column(nullable = false, length = 255)
    private String customerId;

    private Order (){
        // JPA
    }

    public Order(String customerId) {
        this.id = UUID.randomUUID();
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public UUID getId() {
        return id;
    }
}
