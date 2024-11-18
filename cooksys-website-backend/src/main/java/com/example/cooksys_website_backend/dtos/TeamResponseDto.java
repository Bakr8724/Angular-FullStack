package com.example.cooksys_website_backend.dtos;

import lombok.Data;

@Data
public class TeamResponseDto {
    private Long id;
    private String name;
    private String description;
    private CompanyResponseDto company; // Associated company
}
