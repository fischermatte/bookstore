package org.fischermatte.bookstore.order.service;

import org.fischermatte.bookstore.order.test.support.TestDataInitializer;
import org.fischermatte.bookstore.order.test.unit.DefaultUnitTestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DefaultUnitTestConfiguration.class)
@TestPropertySource(locations = "classpath:unit-test.properties")
@Transactional
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

    @Test
    public void findByTitle() throws Exception {
        List<BookDTO> books = bookQueryService.findByTitle("rÄuber");
        assertThat(books.size()).isEqualTo(3);
        assertThat(books).extracting(BookDTO::getIsbn).containsSequence("123", "234", "345");
    }

    @Test
    public void getByIsbn() throws Exception {
        BookDTO book = bookQueryService.getByIsbn("123");
        assertThat(book.getIsbn()).isEqualTo("123");
        assertThat(book.getTitle()).isEqualTo("Die Räuber 1");
    }


    @Test(expected = BookNotFoundException.class)
    public void getByIsbnNotFound() throws Exception {
        bookQueryService.getByIsbn("000000");
    }
}