package org.fischermatte.bookstore.catalog.domain.service.impl.assembler;

import org.fischermatte.bookstore.catalog.domain.model.book.Author;
import org.fischermatte.bookstore.catalog.domain.model.book.Book;
import org.fischermatte.bookstore.catalog.domain.service.api.BookData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BookAssembler.class})
public class BookAssemblerTest {

    @Autowired
    private BookAssembler bookAssembler;

    @Test
    public void toDtoSingle() throws Exception {
        Book book = new Book();
        book.setAuthor(new Author("Thomas", "Mann"));
        book.setIsbn("1234");
        book.setTitle("Zauberberg");
        book.setId(UUID.randomUUID());
        BookData dto = bookAssembler.toDto(book);
        Assert.assertEquals(book.getIsbn(), dto.getIsbn());
        Assert.assertEquals(book.getTitle(), dto.getTitle());
        Assert.assertEquals(book.getAuthor().getFirstName(), dto.getAuthorFirstName());
        Assert.assertEquals(book.getAuthor().getLastName(), dto.getAuthorLastName());
    }

    @Test
    public void toDtoList() throws Exception {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        book.setAuthor(new Author("Thomas", "Mann"));
        book.setIsbn("1234");
        book.setTitle("Zauberberg");
        book.setId(UUID.randomUUID());
        books.add(book);
        List<BookData> dtos = bookAssembler.toDto(books);
        Assert.assertEquals(book.getIsbn(), dtos.get(0).getIsbn());
        Assert.assertEquals(book.getTitle(), dtos.get(0).getTitle());
        Assert.assertEquals(book.getAuthor().getFirstName(), dtos.get(0).getAuthorFirstName());
        Assert.assertEquals(book.getAuthor().getLastName(), dtos.get(0).getAuthorLastName());
    }
}