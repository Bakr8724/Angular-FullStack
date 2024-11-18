package com.example.cooksys_website_backend.mappers;

import com.example.cooksys_website_backend.dtos.UserResponseDto;
import com.example.cooksys_website_backend.entities.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    // Map a single User entity to UserResponseDto
    UserResponseDto entityToResponseDto(User user);

    // Map a list of User entities to a list of UserResponseDtos
    List<UserResponseDto> entitiesToResponseDtos(List<User> users);
}
