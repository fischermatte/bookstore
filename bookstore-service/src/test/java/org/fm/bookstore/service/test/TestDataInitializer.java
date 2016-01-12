package org.fm.bookstore.service.test;

import org.fm.bookstore.service.books.domain.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer {

    private final BookRepository bookRepository;
    private final TestDataFactory bookFactory;

    @Autowired
    public TestDataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.bookFactory = new TestDataFactory();
    }

    public void insertBook(String title, String isbn, String authorFirstname, String authorLastname) {
        bookRepository.save(bookFactory.createBook(title, isbn, authorFirstname, authorLastname));
    }
}
