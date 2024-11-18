package com.example.cooksys_website_backend.services.impl;

import com.example.cooksys_website_backend.dtos.TeamResponseDto;
import com.example.cooksys_website_backend.entities.Team;
import com.example.cooksys_website_backend.mappers.TeamMapper;
import com.example.cooksys_website_backend.repositories.TeamRepository;
import com.example.cooksys_website_backend.services.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public List<TeamResponseDto> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        return teamMapper.entitiesToResponseDtos(teams);
    }
}
