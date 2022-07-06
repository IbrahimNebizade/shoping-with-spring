package com.company.shoping.controller;

import com.company.shoping.dto.CreateUserCommand;
import com.company.shoping.dto.CreateUserResponse;
import com.company.shoping.dto.UpdateUserCommand;
import com.company.shoping.dto.UpdateUserResponse;
import com.company.shoping.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserCommand command) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(command));
    }
    @PatchMapping("update/")
    public ResponseEntity<UpdateUserResponse> updateUser( @RequestBody UpdateUserCommand command){

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(command));
    }
    @PostMapping("/favorite")
    public ResponseEntity<?> addFavoriteProduct(){
        return null;
    }

}
