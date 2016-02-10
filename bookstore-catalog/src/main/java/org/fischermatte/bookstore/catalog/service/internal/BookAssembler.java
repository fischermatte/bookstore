package org.fischermatte.bookstore.catalog.service.internal;

import org.fischermatte.bookstore.catalog.domain.book.Author;
import org.fischermatte.bookstore.catalog.domain.book.Book;
import org.fischermatte.bookstore.catalog.service.AuthorData;
import org.fischermatte.bookstore.catalog.service.BookData;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookAssembler {
    public List<BookData> toDto(List<Book> books) {
        List<BookData> target = new ArrayList<>();
        if (CollectionUtils.isEmpty(books)) {
            return target;
        }
        books.stream().forEach(book -> target.add(toDto(book)));
        return target;
    }

    public BookData toDto(Book book) {
        if (book == null) {
            return null;
        }
        return new BookData(book.getIsbn(), book.getTitle(), toDto(book.getAuthor()));
    }

    private AuthorData toDto(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorData(author.getFirstName(), author.getLastName());
    }

}
