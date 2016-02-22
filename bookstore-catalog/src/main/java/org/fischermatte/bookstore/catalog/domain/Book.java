package org.fischermatte.bookstore.catalog.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "BOOK_UNIQUE_ISBN", columnNames = {"isbn"}))
public class Book {
    @Id
    private UUID id;

    @NotNull
    @Column(nullable = false)
    private String isbn;

    @NotNull
    @Column(nullable = false)
    private String title;

    @Embedded
    private Author author;

    protected Book() {
        // jpa
    }

    public Book(String isbn, String title, Author author) {
        this.id = UUID.randomUUID();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

}
