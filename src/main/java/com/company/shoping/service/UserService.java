package com.company.shoping.service;

import com.company.shoping.dto.CreateUserCommand;
import com.company.shoping.dto.CreateUserResponse;

public interface UserService {
CreateUserResponse cretaeUser(CreateUserCommand command);
}
