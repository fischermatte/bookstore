package org.fischermatte.bookstore.catalog.service.internal;

import org.fischermatte.bookstore.catalog.domain.book.Author;
import org.fischermatte.bookstore.catalog.domain.book.Book;
import org.fischermatte.bookstore.catalog.service.BookData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BookAssembler.class})
public class BookAssemblerTest {

    @Autowired
    private BookAssembler bookAssembler;

    @Test
    public void toDtoSingle() throws Exception {
        Book source = new Book();
        source.setAuthor(new Author("Thomas", "Mann"));
        source.setIsbn("1234");
        source.setTitle("Zauberberg");
        source.setId(UUID.randomUUID());
        BookData target = bookAssembler.toDto(source);
        assertAssemblerResult(source, target);
    }

    @Test
    public void toDtoList() throws Exception {
        List<Book> books = new ArrayList<>();
        Book source = new Book();
        source.setAuthor(new Author("Thomas", "Mann"));
        source.setIsbn("1234");
        source.setTitle("Zauberberg");
        source.setId(UUID.randomUUID());
        books.add(source);
        List<BookData> targets = bookAssembler.toDto(books);
        assertAssemblerResult(source, targets.get(0));
    }

    private void assertAssemblerResult(Book source, BookData target) {
        assertThat(target.getIsbn()).isEqualTo(source.getIsbn());
        assertThat(target.getTitle()).isEqualTo(source.getTitle());
        assertThat(target.getAuthor().getFirstName()).isEqualTo(source.getAuthor().getFirstName());
        assertThat(target.getAuthor().getLastName()).isEqualTo(source.getAuthor().getLastName());
    }
}