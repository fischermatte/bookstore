package com.geolud.bookstore.service.books.service.impl.assembler;

import com.geolud.bookstore.service.books.domain.model.Book;
import com.geolud.bookstore.service.books.service.dto.BookInfoDto;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class BookAssembler {
    public static List<BookInfoDto> toDto(List<Book> books) {
        List<BookInfoDto> target = new ArrayList<>();
        if (CollectionUtils.isEmpty(books)) {
            return target;
        }
        books.stream().forEach(book -> target.add(toDto(book)));
        return target;
    }

    public static BookInfoDto toDto(Book book) {
        BookInfoDto dto = new BookInfoDto();
        dto.setAuthorFirstName(book.getAuthor().getFirstName());
        dto.setAuthorLastName(book.getAuthor().getLastName());
        dto.setIsbn(book.getIsbn());
        return dto;
    }

}
