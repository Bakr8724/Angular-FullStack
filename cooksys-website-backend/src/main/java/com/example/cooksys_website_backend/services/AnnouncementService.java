package com.example.cooksys_website_backend.services;

import com.example.cooksys_website_backend.dtos.AnnouncementResponseDto;

import java.util.List;

public interface AnnouncementService {
    List<AnnouncementResponseDto> getAllAnnouncements();
}
