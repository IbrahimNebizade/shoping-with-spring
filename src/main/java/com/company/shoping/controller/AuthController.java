package com.company.shoping.controller;

import com.company.shoping.dto.CheckOtpRequest;
import com.company.shoping.dto.SignInCommand;
import com.company.shoping.dto.SignInResponse;
import com.company.shoping.service.AuthService;
import com.company.shoping.service.OtpService;
import com.company.shoping.service.UserService;
import com.company.shoping.service.impl.OtpServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/auth")
public class AuthController {
    private final OtpService otpService;
    private final AuthService authService;
    @PostMapping("/check/otp")
    public ResponseEntity<Void> checkOtp(@RequestBody CheckOtpRequest checkOtpRequest){
        otpService.checkOtp(checkOtpRequest);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PostMapping("/signIn")
    public ResponseEntity<SignInResponse> signIn(@RequestBody SignInCommand command){
        return ResponseEntity.ok(authService.signIn(command));
    }
}
