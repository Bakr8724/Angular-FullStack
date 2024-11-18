package com.example.cooksys_website_backend.services.impl;

import com.example.cooksys_website_backend.dtos.ProjectResponseDto;
import com.example.cooksys_website_backend.entities.Project;
import com.example.cooksys_website_backend.mappers.ProjectMapper;
import com.example.cooksys_website_backend.repositories.ProjectRepository;
import com.example.cooksys_website_backend.services.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public List<ProjectResponseDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projectMapper.entitiesToResponseDtos(projects);
    }
}
