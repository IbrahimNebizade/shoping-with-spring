package com.company.shoping.mapper;

import com.company.shoping.dto.CreateUserCommand;
import com.company.shoping.dto.FindUserResponse;
import com.company.shoping.model.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

public static final UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

@Mapping(target = "id",ignore = true)
@Mapping(target = "createdAt",ignore = true)
@Mapping(target = "roleId",ignore = true)
@Mapping(target = "productsList",ignore = true)
@Mapping(target = "billsList",ignore = true)
public abstract Users createUserCommandToUser(CreateUserCommand command);

}
