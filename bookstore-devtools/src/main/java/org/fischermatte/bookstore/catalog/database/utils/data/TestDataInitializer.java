package org.fischermatte.bookstore.catalog.database.utils.data;

import org.fischermatte.bookstore.catalog.domain.book.Author;
import org.fischermatte.bookstore.catalog.domain.book.BookRepository;

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
