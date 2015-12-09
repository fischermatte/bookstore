package com.geolud.bookstore.service.database.utils;

import com.geolud.bookstore.service.books.domain.model.Author;
import com.geolud.bookstore.service.books.domain.repository.BookRepository;
import com.geolud.bookstore.service.testdata.TestDataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestDataInitializer {

    private final BookRepository bookRepository;
    private final TestDataFactory testDataFactory;

    @Autowired
    public TestDataInitializer(BookRepository bookRepository, TestDataFactory testDataFactory) {
        this.bookRepository = bookRepository;
        this.testDataFactory = testDataFactory;
    }

    public void insertData(){
        Author author = testDataFactory.createAuthor("Friedrich", "Schiller");
        bookRepository.save(testDataFactory.createBook("Die Räuber 1","123", author));
        bookRepository.save(testDataFactory.createBook("Die Räuber 2","456", author));
        bookRepository.save(testDataFactory.createBook("Die Räuber 3","789", author));
    }
}
