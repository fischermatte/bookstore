package org.fischermatte.bookstore.catalog.domain.repository;

import org.fischermatte.bookstore.catalog.domain.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query("SELECT b FROM Book b WHERE UPPER(b.title) like CONCAT('%',UPPER(:title),'%') ORDER BY b.title")
    List<Book> findByTitle(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE UPPER(b.isbn) like UPPER(:isbn)")
    Book getByIsbn(@Param("isbn") String isbn);
}
