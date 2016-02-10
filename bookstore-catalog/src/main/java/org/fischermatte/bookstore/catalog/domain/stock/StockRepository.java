package org.fischermatte.bookstore.catalog.domain.stock;

import org.fischermatte.bookstore.catalog.domain.stock.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Stock, UUID> {
}
