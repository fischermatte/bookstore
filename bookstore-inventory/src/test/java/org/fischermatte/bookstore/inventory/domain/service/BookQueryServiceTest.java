package org.fischermatte.bookstore.inventory.domain.service;

import org.fischermatte.bookstore.inventory.domain.service.api.BookData;
import org.fischermatte.bookstore.inventory.domain.service.exception.BookNotFoundException;
import org.fischermatte.bookstore.inventory.test.BookstoreIntegrationTest;
import org.fischermatte.bookstore.inventory.test.TestDataInitializer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@BookstoreIntegrationTest
public class BookQueryServiceTest {

    @Autowired
    private BookQueryService bookQueryService;
    @Autowired
    private TestDataInitializer dataInitializer;

    @Before
    public void setUp() throws Exception {
        dataInitializer.insertBook("Die Räuber 1", "123", "Friedrich", "Schiller");
        dataInitializer.insertBook("Die Räuber 3", "345", "Friedrich", "Schiller");
        dataInitializer.insertBook("Die Räuber 2", "234", "Friedrich", "Schiller");
        dataInitializer.insertBook("Faust", "456", "Johann Wolfgang", "Goethe");
    }

    @After
    public void tearDown() throws Exception {
        dataInitializer.deleteBooks();
    }

    @Test
    public void findByTitle() throws Exception {
        List<BookData> books = bookQueryService.findByTitle("rÄuber");
        Assert.assertEquals(3, books.size());
        Assert.assertEquals("123", books.get(0).getIsbn());
        Assert.assertEquals("234", books.get(1).getIsbn());
        Assert.assertEquals("345", books.get(2).getIsbn());
    }

    @Test
    public void getByIsbn() throws Exception {
        BookData book = bookQueryService.getByIsbn("123");
        Assert.assertEquals("123", book.getIsbn());
        Assert.assertEquals("Die Räuber 1", book.getTitle());
    }


    @Test(expected = BookNotFoundException.class)
    public void getByIsbnNotFound() throws Exception {
        bookQueryService.getByIsbn("000000");
    }
}