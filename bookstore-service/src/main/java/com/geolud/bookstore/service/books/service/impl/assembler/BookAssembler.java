package com.geolud.bookstore.service.books.service.impl.assembler;

import com.geolud.bookstore.service.books.domain.model.Book;
import com.geolud.bookstore.service.books.service.api.BookData;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class BookAssembler {
    public static List<BookData> toDto(List<Book> books) {
        List<BookData> target = new ArrayList<>();
        if (CollectionUtils.isEmpty(books)) {
            return target;
        }
        books.stream().forEach(book -> target.add(toDto(book)));
        return target;
    }

    public static BookData toDto(Book book) {
        BookData dto = new BookData();
        dto.setAuthorFirstName(book.getAuthor().getFirstName());
        dto.setAuthorLastName(book.getAuthor().getLastName());
        dto.setIsbn(book.getIsbn());
        return dto;
    }

}
