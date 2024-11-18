package com.example.cooksys_website_backend.dtos;

import lombok.Data;

@Data
public class TeamRequestDto {
    private String name;
    private String description;
    private Long companyId; // ID of the associated company
}
