package com.company.shoping.service;

import com.company.shoping.dto.SignInCommand;
import com.company.shoping.dto.SignInResponse;

public interface AuthService {
    SignInResponse signIn(SignInCommand command);
}
