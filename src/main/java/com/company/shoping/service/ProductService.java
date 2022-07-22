package com.company.shoping.service;

import com.company.shoping.dto.*;

public interface ProductService {
    AddProductResponse addProduct(AddProductCommand command);

    void deleteProductById(Long id);
    UpdateProductResponse updateProduct(UpdateProductCommand command);

    FindProductByName findByNameProduct(String name);
}
