package com.example.cooksys_website_backend.mappers;

import com.example.cooksys_website_backend.dtos.ProjectResponseDto;
import com.example.cooksys_website_backend.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    // Map a single Project entity to ProjectResponseDto
    @Mapping(target = "team", source = "team") // Nested mapping
    ProjectResponseDto entityToResponseDto(Project project);

    // Map a list of Project entities to a list of ProjectResponseDtos
    List<ProjectResponseDto> entitiesToResponseDtos(List<Project> projects);
}
