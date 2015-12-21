package com.geolud.bookstore.service.rest.controller;

import com.geolud.bookstore.service.BookstoreServer;
import com.geolud.bookstore.service.testutils.TestDataInitializer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BookstoreServer.class)
@WebIntegrationTest
public class BookControllerIT {

    @Autowired
    private TestDataInitializer dataInitializer;

    @Before
    public void setUp() throws Exception {
        dataInitializer.insertBook("Die Räuber 1", "123", "Friedrich", "Schiller");
        dataInitializer.insertBook("Die Räuber 2", "234", "Friedrich", "Schiller");
        dataInitializer.insertBook("Die Räuber 3", "345", "Friedrich", "Schiller");
        dataInitializer.insertBook("Faust", "456", "Johann Wolfgang", "Goethe");
    }

    @Test
    public void searchByTitle(){
//        restTemplate.getForObject("http://localhost:8888/book/", BookData.class);
    }

}