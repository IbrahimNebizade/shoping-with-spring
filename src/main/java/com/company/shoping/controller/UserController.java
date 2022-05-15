package com.company.shoping.controller;

import com.company.shoping.dto.CreateUserCommand;
import com.company.shoping.dto.CreateUserResponse;
import com.company.shoping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.cretaeUser(command));
    }

}
