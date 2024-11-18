package com.example.cooksys_website_backend.services;

import com.example.cooksys_website_backend.dtos.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();
}
