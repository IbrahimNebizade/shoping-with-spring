package com.company.shoping.mapper;

import com.company.shoping.dto.CreateUserCommand;
import com.company.shoping.model.User;
import com.company.shoping.model.UserLoginDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class LoginDetailsMapper {
    public static final LoginDetailsMapper INSTANCE= Mappers.getMapper(LoginDetailsMapper.class);

    public abstract UserLoginDetails toLoginDetailsToCommands(CreateUserCommand command, User user);
}
