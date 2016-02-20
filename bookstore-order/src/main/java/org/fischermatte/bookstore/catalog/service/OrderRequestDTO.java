package org.fischermatte.bookstore.catalog.service;

import org.hibernate.validator.constraints.NotEmpty;

public class OrderRequestDTO {

    @NotEmpty
    private String customerId;

    private OrderRequestDTO() {
        // needed for json mapping jackson
    }

    public OrderRequestDTO(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
