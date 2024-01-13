package com.example.CustomerAPI.Service;

import com.example.CustomerAPI.DTO.UserDto;
import com.example.CustomerAPI.Entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
