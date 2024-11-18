package com.example.cooksys_website_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cooksys_website_backend.entities.Team;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    // Find teams by company ID
    List<Team> findByCompanyId(Long companyId);

    // Find teams by name
    List<Team> findByNameContainingIgnoreCase(String name);
}
