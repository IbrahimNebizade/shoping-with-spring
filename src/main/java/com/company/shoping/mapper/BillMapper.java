package com.company.shoping.mapper;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.model.Bill;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class BillMapper {
    public static final BillMapper INSTANCE= Mappers.getMapper(BillMapper.class);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "user.id",source = "command.userId")
    @Mapping(target = "product.id",source = "command.productId")
    public abstract Bill createBillCommandtoBill(CreateBillCommand command);
}
