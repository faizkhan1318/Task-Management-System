package com.example.taskmanagementsystem.Service;

import com.example.taskmanagementsystem.Dtos.RequestDtos.AddUserDto;
import com.example.taskmanagementsystem.Models.User;
import com.example.taskmanagementsystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(AddUserDto userDto) {
        User user = new User();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setMobNo(userDto.getMobNo());

        userRepository.save(user);

        return "User Saved Successfully";

    }
}
