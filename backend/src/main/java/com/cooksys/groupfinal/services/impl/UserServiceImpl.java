package com.cooksys.groupfinal.services.impl;

import java.util.Optional;

import com.cooksys.groupfinal.dtos.EmailLoginDto;
import org.springframework.stereotype.Service;

import com.cooksys.groupfinal.dtos.CredentialsDto;
import com.cooksys.groupfinal.dtos.FullUserDto;
import com.cooksys.groupfinal.entities.Credentials;
import com.cooksys.groupfinal.entities.User;
import com.cooksys.groupfinal.exceptions.BadRequestException;
import com.cooksys.groupfinal.exceptions.NotAuthorizedException;
import com.cooksys.groupfinal.exceptions.NotFoundException;
import com.cooksys.groupfinal.mappers.CredentialsMapper;
import com.cooksys.groupfinal.mappers.FullUserMapper;
import com.cooksys.groupfinal.repositories.UserRepository;
import com.cooksys.groupfinal.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;
  private final FullUserMapper fullUserMapper;
	private final CredentialsMapper credentialsMapper;
	
	private User findUser(String username) {
        Optional<User> user = userRepository.findByCredentialsUsernameAndActiveTrue(username);
        if (user.isEmpty()) {
            throw new NotFoundException("The username provided does not belong to an active user.");
        }
        return user.get();
    }

    private User findUserByEmail(String email) {
        Optional<User> user = userRepository.findByProfile_EmailAndActiveTrue(email);
        if (user.isEmpty()) {
            throw new NotFoundException("The email provided does not belong to an active user.");
        }
        return user.get();
    }
	@Override
	public FullUserDto login(CredentialsDto credentialsDto) {
		if (credentialsDto == null || credentialsDto.getUsername() == null || credentialsDto.getPassword() == null) {
            throw new BadRequestException("A username and password are required.");
        }
        Credentials credentialsToValidate = credentialsMapper.dtoToEntity(credentialsDto);
        User userToValidate = findUser(credentialsDto.getUsername());
        if (!userToValidate.getCredentials().equals(credentialsToValidate)) {
            throw new NotAuthorizedException("The provided credentials are invalid.");
        }
        if (userToValidate.getStatus().equals("PENDING")) {
        	userToValidate.setStatus("JOINED");
        	userRepository.saveAndFlush(userToValidate);
        }
        return fullUserMapper.entityToFullUserDto(userToValidate);
	}

    @Override
    public FullUserDto login(EmailLoginDto emailLoginDto) {
        if (emailLoginDto == null || emailLoginDto.getEmail() == null || emailLoginDto.getPassword() == null) {
            throw new BadRequestException("An email and password are required.");
        }
        User userToValidate = userRepository.findByProfile_EmailAndActiveTrue(emailLoginDto.getEmail())
                .orElseThrow(() -> new NotFoundException("The email provided does not belong to an active user."));
        if (!userToValidate.getCredentials().getPassword().equals(emailLoginDto.getPassword())) {
            throw new NotAuthorizedException("The provided credentials are invalid.");
        }
        if (userToValidate.getStatus().equals("PENDING")) {
        	userToValidate.setStatus("JOINED");
        	userRepository.saveAndFlush(userToValidate);
        }
        return fullUserMapper.entityToFullUserDto(userToValidate);
    }
}
