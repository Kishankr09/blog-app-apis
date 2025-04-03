package com.kishan.blogappapis.services;

import com.kishan.blogappapis.entities.User;
import com.kishan.blogappapis.payloads.UserDto;

import java.util.List;

public interface UserService {

   UserDto createUser(UserDto user);
   UserDto updateUser(UserDto user, Integer userId);
   UserDto getUserById(Integer userId);

   List<UserDto> getAllUsers();

   void deleteUser(Integer userId);
}
