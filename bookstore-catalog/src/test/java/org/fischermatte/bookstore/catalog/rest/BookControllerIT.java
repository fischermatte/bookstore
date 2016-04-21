package org.fischermatte.bookstore.catalog.rest;

import org.fischermatte.bookstore.catalog.service.BookDTO;
import org.fischermatte.bookstore.catalog.test.integration.CatalogIntegrationTest;
import org.fischermatte.bookstore.catalog.test.integration.BaseUrlConfiguration;
import org.fischermatte.bookstore.catalog.test.support.TestDataInitializer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@CatalogIntegrationTest
public class BookControllerIT {
    @Autowired
    private BaseUrlConfiguration restTestSupport;
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
        ResponseEntity<BookDTO[]> response = restTemplate.getForEntity(restTestSupport.getBaseUrl() + "/books/search?title=räuBer",
                BookDTO[].class);
        BookDTO[] books = response.getBody();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(books).extracting(BookDTO::getIsbn).containsSequence("123", "234", "345");
    }

    @Test
    public void getByIsbn() {
        ResponseEntity<BookDTO> response = restTemplate.getForEntity(restTestSupport.getBaseUrl() + "/books/isbn/345", BookDTO.class);
        BookDTO book = response.getBody();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(book.getIsbn()).isEqualTo("345");
        assertThat(book.getAuthor().getFirstName()).isEqualTo("Friedrich");
        assertThat(book.getAuthor().getLastName()).isEqualTo("Schiller");
        assertThat(book.getTitle()).isEqualTo("Die Räuber 3");
    }

    @Test
    public void getByIsbnNotFound() {
        ResponseEntity<BookDTO> response = restTemplate.getForEntity(restTestSupport.getBaseUrl() + "/books/isbn/invalid-isbn", BookDTO.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

}