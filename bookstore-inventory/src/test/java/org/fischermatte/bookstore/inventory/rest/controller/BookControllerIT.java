package org.fischermatte.bookstore.inventory.rest.controller;

import org.fischermatte.bookstore.inventory.domain.service.api.BookData;
import org.fischermatte.bookstore.inventory.test.integration.DefaultIntegrationTest;
import org.fischermatte.bookstore.inventory.test.integration.RestUrlSupport;
import org.fischermatte.bookstore.inventory.test.support.TestDataInitializer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@DefaultIntegrationTest
public class BookControllerIT {
    @Autowired
    private RestUrlSupport restUrlSupport;
    @Autowired
    private TestDataInitializer dataInitializer;

    private RestTemplate restTemplate = new RestTemplate();

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
        ResponseEntity<BookData[]> response = restTemplate.getForEntity(restUrlSupport.getBaseUrl() + "/books/search?title=räuBer",
                BookData[].class);
        BookData[] books = response.getBody();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("123", books[0].getIsbn());
        Assert.assertEquals("234", books[1].getIsbn());
        Assert.assertEquals("345", books[2].getIsbn());
    }

    @Test
    public void getByIsbn() {
        ResponseEntity<BookData> response = restTemplate.getForEntity(restUrlSupport.getBaseUrl() + "/books/isbn/345", BookData.class);
        BookData book = response.getBody();
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assert.assertEquals("345", book.getIsbn());
        Assert.assertEquals("Friedrich", book.getAuthorFirstName());
        Assert.assertEquals("Schiller", book.getAuthorLastName());
        Assert.assertEquals("Die Räuber 3", book.getTitle());
    }

}