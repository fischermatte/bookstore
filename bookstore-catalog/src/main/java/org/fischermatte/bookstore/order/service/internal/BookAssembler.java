package org.fischermatte.bookstore.order.service.internal;

import org.fischermatte.bookstore.order.domain.Author;
import org.fischermatte.bookstore.order.domain.Book;
import org.fischermatte.bookstore.order.service.AuthorDTO;
import org.fischermatte.bookstore.order.service.BookDTO;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookAssembler {
    public List<BookDTO> toDto(List<Book> books) {
        List<BookDTO> target = new ArrayList<>();
        if (CollectionUtils.isEmpty(books)) {
            return target;
        }
        books.stream().forEach(book -> target.add(toDto(book)));
        return target;
    }

    public BookDTO toDto(Book book) {
        if (book == null) {
            return null;
        }
        return new BookDTO(book.getIsbn(), book.getTitle(), toDto(book.getAuthor()));
    }

    private AuthorDTO toDto(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorDTO(author.getFirstName(), author.getLastName());
    }

}
