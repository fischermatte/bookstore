package org.fischermatte.bookstore.order.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.UUID;

// TODO make table name work with Uppercase.
@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name="\"order\"")  // quotes since order is reserved
public class Order {
    @Id
    private UUID id;

    @NotBlank
    @Length(max = 255)
    @Column(nullable = false, length = 255)
    private String customerId;

    protected Order (){
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
