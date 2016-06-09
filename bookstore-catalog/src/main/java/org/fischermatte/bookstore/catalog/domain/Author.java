package org.fischermatte.bookstore.catalog.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Author {

    private String firstName;
    private String lastName;

    protected Author() {
        // hibernate
    }

    public Author(String firstName, String lastName) {
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
