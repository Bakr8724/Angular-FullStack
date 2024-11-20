package com.cooksys.groupfinal.mappers;

import com.cooksys.groupfinal.dtos.ProjectDto;
import com.cooksys.groupfinal.dtos.TeamDto;
import com.cooksys.groupfinal.dtos.TeamRequestDto;
import com.cooksys.groupfinal.entities.Project;
import com.cooksys.groupfinal.entities.Team;
import com.cooksys.groupfinal.entities.User;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-20T14:14:56-0800",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class TeamMapperImpl implements TeamMapper {

    @Autowired
    private BasicUserMapper basicUserMapper;

    @Override
    public TeamDto entityToDto(Team team) {
        if ( team == null ) {
            return null;
        }

        TeamDto teamDto = new TeamDto();

        teamDto.setId( team.getId() );
        teamDto.setName( team.getName() );
        teamDto.setDescription( team.getDescription() );
        teamDto.setTeammates( basicUserMapper.entitiesToBasicUserDtos( team.getTeammates() ) );
        teamDto.setProjects( projectSetToProjectDtoSet( team.getProjects() ) );

        return teamDto;
    }

    @Override
    public Set<TeamDto> entitiesToDtos(Set<Team> teams) {
        if ( teams == null ) {
            return null;
        }

        Set<TeamDto> set = LinkedHashSet.newLinkedHashSet( teams.size() );
        for ( Team team : teams ) {
            set.add( entityToDto( team ) );
        }

        return set;
    }

    @Override
    public Team dtoToEntity(TeamRequestDto teamRequestDto) {
        if ( teamRequestDto == null ) {
            return null;
        }

        Team team = new Team();

        team.setName( teamRequestDto.getName() );
        team.setDescription( teamRequestDto.getDescription() );
        Set<User> set = teamRequestDto.getTeammates();
        if ( set != null ) {
            team.setTeammates( new LinkedHashSet<User>( set ) );
        }

        return team;
    }

    protected ProjectDto projectToProjectDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setId( project.getId() );
        projectDto.setName( project.getName() );
        projectDto.setDescription( project.getDescription() );
        projectDto.setActive( project.isActive() );

        return projectDto;
    }

    protected Set<ProjectDto> projectSetToProjectDtoSet(Set<Project> set) {
        if ( set == null ) {
            return null;
        }

        Set<ProjectDto> set1 = LinkedHashSet.newLinkedHashSet( set.size() );
        for ( Project project : set ) {
            set1.add( projectToProjectDto( project ) );
        }

        return set1;
    }
}
