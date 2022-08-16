package com.company.shoping.service.impl;

import com.company.shoping.dto.*;
import com.company.shoping.event.MailSender;
import com.company.shoping.mapper.FavoriteMapper;
import com.company.shoping.mapper.UserMapper;
import com.company.shoping.repository.FavoriteRepository;
import com.company.shoping.repository.ProductRepository;
import com.company.shoping.repository.UserRepository;
import com.company.shoping.service.OtpService;
import com.company.shoping.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final OtpService otpService;

    @Override
    public CreateUserResponse createUser(CreateUserCommand command) {
        log.info("ActionLog.{}.createUser.start - command:{}", getClass().getSimpleName(), command);
       userRepository.findUnique(command.getEmail(), command.getPhone()).ifPresent(user -> {
            throw new RuntimeException("exception.email.and.number.already.exist");
        });
        var user = UserMapper.INSTANCE.createUserCommandToUser(command);
        otpService.createOtp(user.getEmail());
        user = userRepository.save(user);
        log.info("ActionLog.{}.createUser.end - command:{}", getClass().getSimpleName(), command);
        return new CreateUserResponse(user.getId());
    }


    @Override
    public UpdateUserResponse updateUser(UpdateUserCommand command) {
        userRepository.findById(command.getId()).ifPresent(user -> {
            user.setName(command.getName());
            user.setSurname(command.getSurname());
            user.setBirthDate(command.getBirthDate());
            user.setEmail(command.getEmail());
            user.setPassword(command.getPassword());
            user.setPhone(command.getPhone());
            userRepository.save(user);
        });
        return UpdateUserResponse.builder()
                .name(command.getName())
                .surname(command.getSurname())
                .build();
    }

    @Override
    public void deleteUser(Long id) {
       userRepository.deleteById(id);
    }

    @Override
    public FindUserResponse findUserById(Long id) {
       var user= userRepository.findById(id).orElseThrow(() -> new RuntimeException("user.not-found"));
        return FindUserResponse.builder()
                .id(id)
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .balance(user.getBalance())
                .phone(user.getPhone())
                .birthDate(user.getBirthDate())
                .build();
    }



}
