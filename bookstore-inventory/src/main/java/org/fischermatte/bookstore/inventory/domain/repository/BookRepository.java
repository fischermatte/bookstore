package org.fischermatte.bookstore.inventory.domain.repository;

import org.fischermatte.bookstore.inventory.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Query("SELECT b FROM Book b WHERE UPPER(b.title)like CONCAT('%',UPPER(:title),'%') ORDER BY b.title")
    List<Book> searchByTitle(@Param("title") String title);
}
