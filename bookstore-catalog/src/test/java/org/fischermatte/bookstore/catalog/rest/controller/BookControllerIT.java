package org.fischermatte.bookstore.catalog.rest.controller;

import org.fischermatte.bookstore.catalog.domain.service.api.BookData;
import org.fischermatte.bookstore.catalog.test.integration.DefaultIntegrationTest;
import org.fischermatte.bookstore.catalog.test.integration.RestTestSupport;
import org.fischermatte.bookstore.catalog.test.support.TestDataInitializer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DefaultIntegrationTest
public class BookControllerIT {
    @Autowired
    private RestTestSupport restTestSupport;
    @Autowired
    private TestDataInitializer dataInitializer;

    private TestRestTemplate restTemplate = new TestRestTemplate();

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
    public void searchByTitle() {
        ResponseEntity<BookData[]> response = restTemplate.getForEntity(restTestSupport.getBaseUrl() + "/books/search?title=räuBer",
                BookData[].class);
        BookData[] books = response.getBody();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("123", books[0].getIsbn());
        Assert.assertEquals("234", books[1].getIsbn());
        Assert.assertEquals("345", books[2].getIsbn());
    }

    @Test
    public void getByIsbn() {
        ResponseEntity<BookData> response = restTemplate.getForEntity(restTestSupport.getBaseUrl() + "/books/isbn/345", BookData.class);
        BookData book = response.getBody();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("345", book.getIsbn());
        Assert.assertEquals("Friedrich", book.getAuthorFirstName());
        Assert.assertEquals("Schiller", book.getAuthorLastName());
        Assert.assertEquals("Die Räuber 3", book.getTitle());
    }

    @Test
    public void getByIsbnNotFound() {
        ResponseEntity<BookData> response = restTemplate.getForEntity(restTestSupport.getBaseUrl() + "/books/isbn/invalid-isbn", BookData.class);
        Assert.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

}