package com.cooksys.groupfinal.repositories;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooksys.groupfinal.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByCredentialsUsernameAndActiveTrue(String username);


    Optional<User> findByProfile_EmailAndActiveTrue(String email);
}