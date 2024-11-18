package com.example.cooksys_website_backend.services;

import com.example.cooksys_website_backend.dtos.CompanyResponseDto;

import java.util.List;

public interface CompanyService {
    List<CompanyResponseDto> getAllCompanies();
}
