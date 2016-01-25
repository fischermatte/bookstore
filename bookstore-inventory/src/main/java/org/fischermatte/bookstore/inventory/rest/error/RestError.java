package org.fischermatte.bookstore.inventory.rest.error;

public class RestError {

    private String message;

    public RestError(Throwable t) {
        this.message = t.getMessage();

    }

    public String getMessage() {
        return message;
    }

}
