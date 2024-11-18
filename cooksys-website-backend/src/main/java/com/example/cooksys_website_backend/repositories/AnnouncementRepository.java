package com.example.cooksys_website_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cooksys_website_backend.entities.Announcement;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {

    // Find announcements by company ID
    List<Announcement> findByCompanyId(Long companyId);

    // Find announcements by author ID
    List<Announcement> findByAuthorId(Long authorId);
}
