package org.fischermatte.bookstore.order.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

// TODO make table name work with Uppercase.
@Entity
@Table(name="\"order\"")  // quotes since order is reserved
public class Order {
    @Id
    private UUID id;

    @NotNull
    @Column(nullable = false)
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
}
