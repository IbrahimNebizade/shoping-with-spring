package com.company.shoping.mapper;

import com.company.shoping.dto.CreateUserCommand;
import com.company.shoping.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class UserMapper {

public static final UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

@Mapping(target = "id",ignore = true)
@Mapping(target = "createdAt",ignore = true)
@Mapping(target = "role",ignore = true)
public abstract User createUserCommandToUser(CreateUserCommand command);
}
