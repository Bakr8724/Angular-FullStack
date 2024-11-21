package com.cooksys.groupfinal.services.impl;

import com.cooksys.groupfinal.dtos.TeamDto;
import com.cooksys.groupfinal.dtos.TeamRequestDto;
import com.cooksys.groupfinal.entities.Company;
import com.cooksys.groupfinal.entities.Team;
import com.cooksys.groupfinal.entities.User;
import com.cooksys.groupfinal.exceptions.NotFoundException;
import com.cooksys.groupfinal.mappers.FullUserMapper;
import com.cooksys.groupfinal.mappers.TeamMapper;
import com.cooksys.groupfinal.repositories.CompanyRepository;
import com.cooksys.groupfinal.repositories.ProjectRepository;
import com.cooksys.groupfinal.repositories.TeamRepository;
import com.cooksys.groupfinal.repositories.UserRepository;
import org.springframework.stereotype.Service;

import com.cooksys.groupfinal.services.TeamService;

import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final CompanyRepository companyRepository;
    private final UserRepository userRepository;
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;
    private final FullUserMapper userMapper;

    @Override
    public TeamDto createTeam(Long companyId, TeamRequestDto teamRequestDto) {
        Team team = teamMapper.dtoToEntity(teamRequestDto);
        Company company = companyRepository.findById(companyId).orElseThrow(() -> new NotFoundException("Company not found"));
        team.setCompany(company);
        team.setTeammates(userMapper.listEntitiesToSet(userRepository.findAllById(teamRequestDto.getTeammates())));
        return teamMapper.entityToDto(teamRepository.saveAndFlush(team));
    }
}
