package com.company.shoping.service.impl;

import com.company.shoping.dto.AddProductCommand;
import com.company.shoping.dto.AddProductResponse;
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
        productRepository.insert(product);
        log.info("ActionLog.{}.addProduct.end - command: {} ",getClass().getSimpleName(),command);
        return new AddProductResponse(product.getId());
    }
}
