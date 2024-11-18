package com.example.cooksys_website_backend.services;

import com.example.cooksys_website_backend.dtos.ProjectResponseDto;

import java.util.List;

public interface ProjectService {
    List<ProjectResponseDto> getAllProjects();
}
