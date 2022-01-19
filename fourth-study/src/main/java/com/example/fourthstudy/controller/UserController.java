package com.example.fourthstudy.controller;

import com.example.fourthstudy.model.User;
import com.example.fourthstudy.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return new ResponseEntity<>(
            userService.findAllUsers(),
            HttpStatus.OK
        );
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(
                userService.findUserById(id),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser( @RequestBody User user) { //TODO: Valid annotation
        return new ResponseEntity<>(
                userService.createUser(user),
                HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user) {
        return new ResponseEntity<>(
                userService.updateUser(id,user),
                HttpStatus.OK
        );
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(
                HttpStatus.OK
        );
    }

}
