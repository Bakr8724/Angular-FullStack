package com.example.cooksys_website_backend.dtos;

import lombok.Data;

@Data
public class AnnouncementResponseDto {
    private Long id;
    private String title;
    private String message;
    private CompanyResponseDto company; // Associated company
    private UserResponseDto author;     // Author details
}
