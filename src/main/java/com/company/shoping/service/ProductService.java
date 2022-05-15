package com.company.shoping.service;

import com.company.shoping.dto.AddProductCommand;
import com.company.shoping.dto.AddProductResponse;

public interface ProductService {
    AddProductResponse addProduct(AddProductCommand command);
}
