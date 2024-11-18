package com.example.cooksys_website_backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cooksys_website_backend.entities.Project;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    // Find all active projects
    List<Project> findByActiveTrue();

    // Find projects by team ID
    List<Project> findByTeamId(Long teamId);
}
