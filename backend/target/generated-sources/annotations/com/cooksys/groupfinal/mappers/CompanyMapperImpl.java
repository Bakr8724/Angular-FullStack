package com.cooksys.groupfinal.mappers;

import com.cooksys.groupfinal.dtos.CompanyDto;
import com.cooksys.groupfinal.entities.Company;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-20T14:14:56-0800",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class CompanyMapperImpl implements CompanyMapper {

    @Override
    public CompanyDto entityToDto(Company company) {
        if ( company == null ) {
            return null;
        }

        CompanyDto companyDto = new CompanyDto();

        companyDto.setId( company.getId() );
        companyDto.setName( company.getName() );

        return companyDto;
    }

    @Override
    public Set<CompanyDto> entitiesToDtos(Set<Company> companies) {
        if ( companies == null ) {
            return null;
        }

        Set<CompanyDto> set = LinkedHashSet.newLinkedHashSet( companies.size() );
        for ( Company company : companies ) {
            set.add( entityToDto( company ) );
        }

        return set;
    }

    @Override
    public Set<CompanyDto> entitiesToDtos(List<Company> companies) {
        if ( companies == null ) {
            return null;
        }

        Set<CompanyDto> set = LinkedHashSet.newLinkedHashSet( companies.size() );
        for ( Company company : companies ) {
            set.add( entityToDto( company ) );
        }

        return set;
    }
}
