package com.geolud.bookstore.service.database.utils.data;

import com.geolud.bookstore.service.books.domain.model.Author;
import com.geolud.bookstore.service.books.domain.repository.BookRepository;

public class TestDataInitializer {

    private final BookRepository bookRepository;
    private final TestDataFactory testDataFactory;

    public TestDataInitializer(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.testDataFactory = new TestDataFactory();
    }

    public void insertData(){
        Author author = testDataFactory.createAuthor("Friedrich", "Schiller");
        bookRepository.save(testDataFactory.createBook("Die Räuber 1","123", author));
        bookRepository.save(testDataFactory.createBook("Die Räuber 2","456", author));
        bookRepository.save(testDataFactory.createBook("Die Räuber 3","789", author));
    }
}
