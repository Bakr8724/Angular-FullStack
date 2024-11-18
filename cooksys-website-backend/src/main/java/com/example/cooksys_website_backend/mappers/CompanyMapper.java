package com.example.cooksys_website_backend.mappers;

import com.example.cooksys_website_backend.dtos.CompanyResponseDto;
import com.example.cooksys_website_backend.entities.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    // Map a single Company entity to CompanyResponseDto
    CompanyResponseDto entityToResponseDto(Company company);

    // Map a list of Company entities to a list of CompanyResponseDtos
    List<CompanyResponseDto> entitiesToResponseDtos(List<Company> companies);
}
