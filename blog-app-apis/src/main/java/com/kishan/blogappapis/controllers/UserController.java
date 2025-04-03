package com.kishan.blogappapis.controllers;

import com.kishan.blogappapis.payloads.ApiResponse;
import com.kishan.blogappapis.payloads.UserDto;
import com.kishan.blogappapis.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Post - Create User
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto response = this.userService.createUser(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    //Put - Update User
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer userId) {

        UserDto response = this.userService.updateUser(userDto, userId);

        return  ResponseEntity.ok(response);
    }

    //Delete - Delete User
    @DeleteMapping("/{userId}")
    public ResponseEntity<ApiResponse>deleteUser(@PathVariable("userId") Integer userId) {
        this.userService.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted Successfully",true),HttpStatus.OK);
    }


    //GET - user get
    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(this.userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto>getSingleUser(@PathVariable("userId") Integer userId ) {
        return ResponseEntity.ok(this.userService.getUserById(userId));
    }
}
