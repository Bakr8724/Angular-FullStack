package com.example.cooksys_website_backend.dtos;

import lombok.Data;

@Data
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String description;
    private Boolean active;
    private TeamResponseDto team; // Associated team
}
