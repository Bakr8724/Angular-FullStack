package com.example.cooksys_website_backend.dtos;

import lombok.Data;

@Data
public class ProjectRequestDto {
    private String name;
    private String description;
    private Boolean active;
    private Long teamId; // ID of the associated team
}
