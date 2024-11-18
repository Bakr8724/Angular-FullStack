package com.example.cooksys_website_backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cooksys_website_backend.entities.Company;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    // Find companies by name (case-insensitive search)
    List<Company> findByNameContainingIgnoreCase(String name);
}
