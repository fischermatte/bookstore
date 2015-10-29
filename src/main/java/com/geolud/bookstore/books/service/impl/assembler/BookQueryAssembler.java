package com.geolud.bookstore.books.service.impl.assembler;

import com.geolud.bookstore.books.domain.model.Book;
import com.geolud.bookstore.books.service.dto.BookQueryResultDto;

public class BookQueryAssembler {
    public static BookQueryResultDto toDto(Book book) {
        BookQueryResultDto dto = new BookQueryResultDto();
        dto.setAuthorFirstName(book.getAuthor().getFirstName());
        dto.setAuthorLastName(book.getAuthor().getLastName());
        dto.setIsbn(book.getIsbn());
        return dto;
    }
}
