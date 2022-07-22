package com.company.shoping.repository;

import com.company.shoping.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Products,Long> {
    @Query("select p.name,p.price,p.stock from Products p where p.name=:name")
    Optional<Products> findByName(@Param("name") String name);
    @Query("select p.price from Products p where p.id=:id")
    Long findPriceByProductId(@Param("id") Long productId);
}
