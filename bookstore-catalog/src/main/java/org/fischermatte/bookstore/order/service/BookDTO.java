package org.fischermatte.bookstore.order.service;

public class BookDTO {

    private String isbn;
    private String title;
    private AuthorDTO author;

    private BookDTO() {
        // needed for json mapping jackson
    }

    public BookDTO(String isbn, String title, AuthorDTO author) {
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

    public AuthorDTO getAuthor() {
        return author;
    }


}
