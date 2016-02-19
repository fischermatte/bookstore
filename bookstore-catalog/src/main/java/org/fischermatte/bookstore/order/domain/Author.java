package org.fischermatte.bookstore.order.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Author {

    @Column(name = "AUTHOR_FIRSTNAME")
    private String firstName;
    @Column(name = "AUTHOR_LASTNAME")
    private String lastName;

    private Author() {
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
