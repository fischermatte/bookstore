package org.fischermatte.bookstore.catalog.service;

public class AuthorData {
    private String firstName;
    private String lastName;

    private AuthorData() {
        // needed for json mapping jackson
    }

    public AuthorData(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
