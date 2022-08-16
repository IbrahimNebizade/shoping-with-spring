package com.company.shoping.service.impl;

import com.company.shoping.dto.SignInCommand;
import com.company.shoping.dto.SignInResponse;
import com.company.shoping.repository.UserRepository;
import com.company.shoping.service.AuthService;
import com.company.shoping.service.OtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final OtpService otpService;
    @Override
    public SignInResponse signIn(SignInCommand command) {
       var login= userRepository.findByEmail(command.getEmail()).orElseThrow(() -> new RuntimeException("exception.email.not-found"));
       userRepository.findByPassword(command.getPassword()).orElseThrow(() -> new RuntimeException("exception.wrong-password"));
       var otpResponse=otpService.createOtp(command.getEmail());

        return new SignInResponse(otpResponse.getSessionId());
    }
}
