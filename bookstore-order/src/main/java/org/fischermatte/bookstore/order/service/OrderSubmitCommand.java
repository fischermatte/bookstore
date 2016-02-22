package org.fischermatte.bookstore.order.service;

import org.hibernate.validator.constraints.NotEmpty;

public class OrderSubmitCommand {

    @NotEmpty
    private String customerId;

    private OrderSubmitCommand() {
        // needed for json mapping jackson
    }

    public OrderSubmitCommand(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }
}
