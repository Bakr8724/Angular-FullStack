package com.example.cooksys_website_backend.services;

import com.example.cooksys_website_backend.dtos.TeamResponseDto;

import java.util.List;

public interface TeamService {
    List<TeamResponseDto> getAllTeams();
}
