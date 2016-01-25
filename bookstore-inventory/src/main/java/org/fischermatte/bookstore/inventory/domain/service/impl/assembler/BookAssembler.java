package org.fischermatte.bookstore.inventory.domain.service.impl.assembler;

import org.fischermatte.bookstore.inventory.domain.model.Book;
import org.fischermatte.bookstore.inventory.domain.service.api.BookData;
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
        BookData dto = new BookData();
        dto.setAuthorFirstName(book.getAuthor().getFirstName());
        dto.setAuthorLastName(book.getAuthor().getLastName());
        dto.setIsbn(book.getIsbn());
        dto.setTitle(book.getTitle());
        return dto;
    }

}