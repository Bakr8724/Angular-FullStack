package com.example.cooksys_website_backend.services.impl;

import com.example.cooksys_website_backend.dtos.AnnouncementResponseDto;
import com.example.cooksys_website_backend.entities.Announcement;
import com.example.cooksys_website_backend.mappers.AnnouncementMapper;
import com.example.cooksys_website_backend.repositories.AnnouncementRepository;
import com.example.cooksys_website_backend.services.AnnouncementService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementMapper announcementMapper;

    @Override
    public List<AnnouncementResponseDto> getAllAnnouncements() {
        List<Announcement> announcements = announcementRepository.findAll();
        return announcementMapper.entitiesToResponseDtos(announcements);
    }
}
