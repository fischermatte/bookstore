package com.geolud.bookstore.service.books.service.impl.assembler;

import com.geolud.bookstore.service.books.domain.model.Author;
import com.geolud.bookstore.service.books.domain.model.Book;
import com.geolud.bookstore.service.books.service.api.BookData;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BookAssemblerTest {

    // TODO use Autowired instead
    private BookAssembler bookAssembler = new BookAssembler();

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