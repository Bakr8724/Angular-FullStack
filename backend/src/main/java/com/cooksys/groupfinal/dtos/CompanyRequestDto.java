package com.cooksys.groupfinal.dtos;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class CompanyRequestDto {

    private String name;
    private String description;

    private Set<Long> teams;
    private Set<Long> employees;

}

