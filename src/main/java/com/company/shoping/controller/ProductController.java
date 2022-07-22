package com.company.shoping.controller;

import com.company.shoping.dto.*;
import com.company.shoping.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/products")
public class ProductController {
    private final ProductService productService;
    @PostMapping("/add/product")
    public ResponseEntity<AddProductResponse> addProduct(AddProductCommand command){
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(command));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long id){
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PatchMapping("/update/")
    public ResponseEntity<UpdateProductResponse> updateProduct(@RequestBody UpdateProductCommand command){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.updateProduct(command));
    }
    @GetMapping("find/{name}")
    public ResponseEntity<FindProductByName> findProductByName(@PathVariable String name){
        return ResponseEntity.ok(productService.findByNameProduct(name));
    }
}
