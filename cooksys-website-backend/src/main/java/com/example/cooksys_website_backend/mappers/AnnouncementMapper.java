package com.example.cooksys_website_backend.mappers;

import com.example.cooksys_website_backend.dtos.AnnouncementResponseDto;
import com.example.cooksys_website_backend.entities.Announcement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnnouncementMapper {
    // Map a single Announcement entity to AnnouncementResponseDto
    @Mapping(target = "company", source = "company") // Nested mapping
    @Mapping(target = "author", source = "author")   // Nested mapping
    AnnouncementResponseDto entityToResponseDto(Announcement announcement);

    // Map a list of Announcement entities to a list of AnnouncementResponseDtos
    List<AnnouncementResponseDto> entitiesToResponseDtos(List<Announcement> announcements);
}
