package com.example.cooksys_website_backend.dtos;

import lombok.Data;

@Data
public class AnnouncementRequestDto {
    private String title;
    private String message;
    private Long companyId; // ID of the associated company
    private Long authorId;  // ID of the author (User)
}
