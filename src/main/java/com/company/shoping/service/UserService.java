package com.company.shoping.service;

import com.company.shoping.dto.CreateUserCommand;
import com.company.shoping.dto.CreateUserResponse;
import com.company.shoping.dto.UpdateUserCommand;
import com.company.shoping.dto.UpdateUserResponse;

public interface UserService {
CreateUserResponse createUser(CreateUserCommand command);

UpdateUserResponse updateUser(UpdateUserCommand command);

}
