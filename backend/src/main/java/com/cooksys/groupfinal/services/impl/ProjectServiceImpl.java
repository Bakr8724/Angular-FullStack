package com.cooksys.groupfinal.services.impl;

import com.cooksys.groupfinal.dtos.ProjectDto;
import com.cooksys.groupfinal.dtos.ProjectRequestDto;
import com.cooksys.groupfinal.entities.Company;
import com.cooksys.groupfinal.entities.Project;
import com.cooksys.groupfinal.entities.Team;
import com.cooksys.groupfinal.exceptions.BadRequestException;
import com.cooksys.groupfinal.mappers.ProjectMapper;
import com.cooksys.groupfinal.repositories.CompanyRepository;
import com.cooksys.groupfinal.repositories.ProjectRepository;
import com.cooksys.groupfinal.repositories.TeamRepository;
import org.springframework.stereotype.Service;

import com.cooksys.groupfinal.services.ProjectService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final CompanyRepository companyRepository;
    private final TeamRepository teamRepository;
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;

    @Override
    public ProjectDto createProject(ProjectRequestDto projectRequestDto, Long companyId, Long teamId) {
        Optional<Company> company = companyRepository.findById(companyId);
        if (company.isEmpty()) {
            throw new BadRequestException("Company doesn't exist");
        }
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isEmpty()) {
            throw new BadRequestException("Team doesn't exist");
        }

        Project project = new Project();
        project.setName(projectRequestDto.getName());
        project.setDescription(projectRequestDto.getDescription());
        project.setActive(projectRequestDto.isActive());
        project.setTeam(team.get());

        
        return projectMapper.entityToDto(projectRepository.saveAndFlush(project));
    }
}
