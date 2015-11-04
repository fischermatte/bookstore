package com.geolud.bookstore.books.domain.repository.impl;

import com.geolud.bookstore.books.domain.model.Author;
import com.geolud.bookstore.books.domain.model.Book;
import com.geolud.bookstore.books.domain.repository.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public List<Book> findByTitle(String isbn) {
        if ("räuber".equals(isbn)){
            Book b = new Book();
            b.setIsbn(isbn);
            b.setAuthor(new Author("Friedrich", "Schiller"));
            List<Book> books = new ArrayList<>();
            books.add(b);
            return books;
        }
        return null;
    }
}
