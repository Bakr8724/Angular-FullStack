package com.example.cooksys_website_backend.dtos;

import lombok.Data;

import java.util.List;

@Data
public class UserResponseDto {
    private Long id;
    private String username;
    private String first;
    private String last;
    private String email;
    private String phone;
    private Boolean active;
    private Boolean admin;
    private String status;
    private List<CompanyResponseDto> companies; // Associated companies
    private List<TeamResponseDto> teams;        // Associated teams
}
