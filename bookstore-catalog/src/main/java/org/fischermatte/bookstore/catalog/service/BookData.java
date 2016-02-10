package org.fischermatte.bookstore.catalog.service;

public class BookData {

    private String isbn;
    private String title;
    private AuthorData author;

    private BookData() {
        // needed for json mapping jackson
    }

    public BookData(String isbn, String title, AuthorData author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public AuthorData getAuthor() {
        return author;
    }


}
