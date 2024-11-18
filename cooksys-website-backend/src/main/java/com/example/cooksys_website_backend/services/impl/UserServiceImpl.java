package com.example.cooksys_website_backend.services.impl;

import com.example.cooksys_website_backend.dtos.UserResponseDto;
import com.example.cooksys_website_backend.entities.User;
import com.example.cooksys_website_backend.mappers.UserMapper;
import com.example.cooksys_website_backend.repositories.UserRepository;
import com.example.cooksys_website_backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.entitiesToResponseDtos(users);
    }
}
