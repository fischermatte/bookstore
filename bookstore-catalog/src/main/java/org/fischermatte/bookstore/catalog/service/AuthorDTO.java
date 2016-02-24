package org.fischermatte.bookstore.catalog.service;

public class AuthorDTO {
    private String firstName;
    private String lastName;

    private AuthorDTO() {
        // needed for json mapping jackson
    }

    public AuthorDTO(String firstName, String lastName) {
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
