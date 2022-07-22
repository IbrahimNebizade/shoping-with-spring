package com.company.shoping.controller;

import com.company.shoping.dto.*;
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
    @PatchMapping("/update")
    public ResponseEntity<UpdateUserResponse> updateUser( @RequestBody UpdateUserCommand command){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.updateUser(command));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PostMapping("/find/{id}")
    public ResponseEntity<FindUserResponse> findByIdUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }
    @PostMapping("/favorite")
    public ResponseEntity<?> addFavoriteProduct(){
        return null;
    }

}
