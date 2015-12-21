package com.geolud.bookstore.service.books.domain.repository;

import com.geolud.bookstore.service.books.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query("SELECT b FROM Book b WHERE UPPER(b.title)like CONCAT('%',UPPER(:title),'%') ORDER BY b.title")
    List<Book> findByTitle(@Param("title") String title);
}
