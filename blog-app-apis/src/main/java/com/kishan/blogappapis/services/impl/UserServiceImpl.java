package com.kishan.blogappapis.services.impl;

import com.kishan.blogappapis.entities.User;
import com.kishan.blogappapis.exceptions.ResourceNotFoundException;
import com.kishan.blogappapis.payloads.UserDto;
import com.kishan.blogappapis.reposirories.UserRepo;
import com.kishan.blogappapis.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.dtoToUser(userDto);
        User savedUser = this.userRepo.save(user);
        return this.userToUserDto(savedUser);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User updatedUser = this.userRepo.save(user);
        UserDto updatedUserDto = this.userToUserDto(updatedUser);
        return updatedUserDto;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

        return this.userToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepo.findAll();
        List<UserDto> userDtos =  users.stream().map(user -> this.userToUserDto(user)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public void deleteUser(Integer userId) {
       User user =  this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));

       this.userRepo.delete(user);
    }

    private User dtoToUser(UserDto userDto) {

        return this.modelMapper.map(userDto, User.class);

        /*
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());

        return user;

         */
    }

    public UserDto userToUserDto(User user) {

        return this.modelMapper.map(user, UserDto.class);

        /*
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setAbout(user.getAbout());
        return userDto;

         */
    }
}
