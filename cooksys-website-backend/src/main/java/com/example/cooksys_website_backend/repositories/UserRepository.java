package com.example.cooksys_website_backend.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cooksys_website_backend.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Find all active users
    List<User> findByActiveTrue();

    // Find by username
    List<User> findByUsername(String username);
}
