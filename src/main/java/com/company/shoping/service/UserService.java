package com.company.shoping.service;

import com.company.shoping.dto.*;

public interface UserService {
CreateUserResponse createUser(CreateUserCommand command);

UpdateUserResponse updateUser(UpdateUserCommand command);

    void deleteUser(Long id);
    FindUserResponse findUserById(Long id);
}
