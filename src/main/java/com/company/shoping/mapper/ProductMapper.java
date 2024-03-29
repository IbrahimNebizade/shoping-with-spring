package com.company.shoping.mapper;

import com.company.shoping.dto.AddProductCommand;
import com.company.shoping.model.Products;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProductMapper {

    public static final ProductMapper INSTANCE= Mappers.getMapper(ProductMapper.class);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "usersList",ignore = true)
    @Mapping(target = "billsList",ignore = true)
    public abstract Products createProductCommandToProduct(AddProductCommand command);


}
