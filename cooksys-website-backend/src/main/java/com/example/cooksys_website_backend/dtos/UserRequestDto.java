package com.example.cooksys_website_backend.dtos;

import lombok.Data;

@Data
public class UserRequestDto {
    private String username;
    private String password;
    private String first;
    private String last;
    private String email;
    private String phone;
    private Boolean active;
    private Boolean admin;
    private String status;
    private Long[] companyIds; // IDs of associated companies
    private Long[] teamIds;    // IDs of associated teams
}
