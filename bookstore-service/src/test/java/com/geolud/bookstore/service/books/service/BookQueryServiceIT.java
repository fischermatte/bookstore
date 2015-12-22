package com.geolud.bookstore.service.books.service;

import com.geolud.bookstore.service.books.service.api.BookData;
import com.geolud.bookstore.service.test.BookstoreIntegrationTest;
import com.geolud.bookstore.service.test.TestDataInitializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@BookstoreIntegrationTest
public class BookQueryServiceIT {

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

    @Test
    public void findByTitle() {
        List<BookData> books = bookQueryService.findByTitle("rÄuber");
        Assert.assertEquals(3, books.size());
        Assert.assertEquals("123", books.get(0).getIsbn());
        Assert.assertEquals("234", books.get(1).getIsbn());
        Assert.assertEquals("345", books.get(2).getIsbn());
    }
}