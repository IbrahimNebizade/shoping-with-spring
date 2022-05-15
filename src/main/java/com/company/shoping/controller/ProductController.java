package com.company.shoping.controller;

import com.company.shoping.dto.AddProductCommand;
import com.company.shoping.dto.AddProductResponse;
import com.company.shoping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;
    @PostMapping("/add/product")
    public ResponseEntity<AddProductResponse> addProduct(AddProductCommand command){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(command));
    }
}
