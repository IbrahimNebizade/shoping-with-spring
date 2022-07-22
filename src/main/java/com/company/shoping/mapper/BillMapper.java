package com.company.shoping.mapper;

import com.company.shoping.dto.CreateBillCommand;
import com.company.shoping.model.Bills;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class BillMapper {
    public static final BillMapper INSTANCE= Mappers.getMapper(BillMapper.class);
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "userId.id",source = "command.userId")
    @Mapping(target = "productId.id",source = "command.productId")
    public abstract Bills createBillCommandoBill(CreateBillCommand command);
}
