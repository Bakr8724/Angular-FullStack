package com.example.cooksys_website_backend.services.impl;

import com.example.cooksys_website_backend.dtos.CompanyResponseDto;
import com.example.cooksys_website_backend.entities.Company;
import com.example.cooksys_website_backend.mappers.CompanyMapper;
import com.example.cooksys_website_backend.repositories.CompanyRepository;
import com.example.cooksys_website_backend.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    @Override
    public List<CompanyResponseDto> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();
        return companyMapper.entitiesToResponseDtos(companies);
    }
}
