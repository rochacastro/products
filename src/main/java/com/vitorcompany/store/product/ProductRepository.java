package com.vitorcompany.store.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(String id);

    @Query("Select p from Product p where (lower(p.name) like %:q% or lower(p.description) like %:q%) and p.price >= :minValue and p.price <= :maxValue")
    List<Product> findBydescriptionAndBetweenValues(String q, BigDecimal minValue, BigDecimal maxValue);
}
