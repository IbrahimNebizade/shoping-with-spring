package com.company.shoping.repository;

import com.company.shoping.model.Product;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product,Long> {
    Optional<Product> findByName(String name);
}
