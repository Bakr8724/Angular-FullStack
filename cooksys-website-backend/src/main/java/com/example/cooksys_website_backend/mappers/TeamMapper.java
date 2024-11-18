package com.example.cooksys_website_backend.mappers;

import com.example.cooksys_website_backend.dtos.TeamResponseDto;
import com.example.cooksys_website_backend.entities.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeamMapper {
    // Map a single Team entity to TeamResponseDto
    @Mapping(target = "company", source = "company") // Nested mapping
    TeamResponseDto entityToResponseDto(Team team);

    // Map a list of Team entities to a list of TeamResponseDtos
    List<TeamResponseDto> entitiesToResponseDtos(List<Team> teams);
}
