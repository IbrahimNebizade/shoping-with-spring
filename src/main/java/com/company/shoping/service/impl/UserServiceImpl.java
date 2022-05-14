package com.company.shoping.service.impl;

import com.company.shoping.dto.CreateUserCommand;
import com.company.shoping.dto.CreateUserResponse;
import com.company.shoping.mapper.LoginDetailsMapper;
import com.company.shoping.mapper.UserMapper;
import com.company.shoping.repository.LoginDetailsRepository;
import com.company.shoping.repository.UserRepository;
import com.company.shoping.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final LoginDetailsRepository loginDetailsRepository;

    @Override
    public CreateUserResponse cretaeUser(CreateUserCommand command) {
        log.info("ActionLog.{}.createUser.start - command:{}", getClass().getSimpleName(), command);
        loginDetailsRepository.findUnique(command.getEmail(), command.getPhone()).ifPresent(user -> {
            throw new RuntimeException("exception.email.and.number.already.exist");
        });
        var user = UserMapper.INSTANCE.createUserCommandToUser(command);
        user = userRepository.insert(user);
        var loginDetail = LoginDetailsMapper.INSTANCE.toLoginDetailsToCommands(command, user);
        loginDetailsRepository.insert(loginDetail);
        log.info("ActionLog.{}.createUser.end - command:{}", getClass().getSimpleName(), command);
        return new CreateUserResponse(user.getId());
    }
}
