package com.cooksys.groupfinal.mappers;

import com.cooksys.groupfinal.dtos.ProjectDto;
import com.cooksys.groupfinal.dtos.ProjectRequestDto;
import com.cooksys.groupfinal.entities.Project;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-20T14:14:56-0800",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Override
    public ProjectDto entityToDto(Project project) {
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

    @Override
    public Set<ProjectDto> entitiesToDtos(Set<Project> projects) {
        if ( projects == null ) {
            return null;
        }

        Set<ProjectDto> set = LinkedHashSet.newLinkedHashSet( projects.size() );
        for ( Project project : projects ) {
            set.add( entityToDto( project ) );
        }

        return set;
    }

    @Override
    public Project dtoToEntity(ProjectRequestDto projectRequestDto) {
        if ( projectRequestDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setName( projectRequestDto.getName() );
        project.setDescription( projectRequestDto.getDescription() );
        if ( projectRequestDto.getActive() != null ) {
            project.setActive( projectRequestDto.getActive() );
        }

        return project;
    }
}
