package com.company.shoping.service.impl;

import com.company.shoping.dto.*;
import com.company.shoping.mapper.ProductMapper;
import com.company.shoping.repository.ProductRepository;
import com.company.shoping.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public AddProductResponse addProduct(AddProductCommand command) {
        log.info("ActionLog.{}.addProduct.start - command: {} ",getClass().getSimpleName(),command);
        var product= ProductMapper.INSTANCE.createProductCommandToProduct(command);
        product=productRepository.save(product);
        log.info("ActionLog.{}.addProduct.end - command: {} ",getClass().getSimpleName(),command);
        return new AddProductResponse(product.getId());
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public UpdateProductResponse updateProduct(UpdateProductCommand command) {
        productRepository.findById(command.getId()).ifPresent(products -> {
            products.setName(command.getName());
            products.setPrice(command.getPrice());
            products.setStock(command.getStock());
            productRepository.save(products);
        });
        return UpdateProductResponse.builder()
                .name(command.getName())
                .price(command.getPrice())
                .stock(command.getStock())
                .build();
    }

    @Override
    public FindProductByName findByNameProduct(String name) {
        var product=productRepository.findByName(name).orElseThrow(() -> new RuntimeException("product.not-found"));
        return FindProductByName.builder()
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
