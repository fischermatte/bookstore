package org.fischermatte.bookstore.catalog.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Author {

    @Column(name = "AUHTOR_FIRSTNAME")
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

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
