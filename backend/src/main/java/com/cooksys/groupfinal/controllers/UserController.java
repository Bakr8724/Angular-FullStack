package com.cooksys.groupfinal.controllers;

import com.cooksys.groupfinal.dtos.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.groupfinal.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	
//	@PostMapping("/login")
//	@CrossOrigin(origins="*")
//    public FullUserDto login(@RequestBody CredentialsDto credentialsDto) {
//        return userService.login(credentialsDto);
//    }

    @PostMapping("/login")
    @CrossOrigin(origins="*")
    public FullUserDto login(@RequestBody EmailLoginDto emailLoginDto) {
        return userService.login(emailLoginDto);
    }


}
