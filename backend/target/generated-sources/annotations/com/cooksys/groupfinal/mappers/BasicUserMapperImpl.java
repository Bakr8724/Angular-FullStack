package com.cooksys.groupfinal.mappers;

import com.cooksys.groupfinal.dtos.BasicUserDto;
import com.cooksys.groupfinal.dtos.UserRequestDto;
import com.cooksys.groupfinal.entities.User;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-20T14:14:56-0800",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class BasicUserMapperImpl implements BasicUserMapper {

    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private CredentialsMapper credentialsMapper;

    @Override
    public BasicUserDto entityToBasicUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        BasicUserDto basicUserDto = new BasicUserDto();

        basicUserDto.setId( user.getId() );
        basicUserDto.setProfile( profileMapper.entityToDto( user.getProfile() ) );
        basicUserDto.setAdmin( user.isAdmin() );
        basicUserDto.setActive( user.isActive() );
        basicUserDto.setStatus( user.getStatus() );

        return basicUserDto;
    }

    @Override
    public Set<BasicUserDto> entitiesToBasicUserDtos(Set<User> users) {
        if ( users == null ) {
            return null;
        }

        Set<BasicUserDto> set = LinkedHashSet.newLinkedHashSet( users.size() );
        for ( User user : users ) {
            set.add( entityToBasicUserDto( user ) );
        }

        return set;
    }

    @Override
    public User requestDtoToEntity(UserRequestDto userRequestDto) {
        if ( userRequestDto == null ) {
            return null;
        }

        User user = new User();

        user.setCredentials( credentialsMapper.dtoToEntity( userRequestDto.getCredentials() ) );
        user.setProfile( profileMapper.dtoToEntity( userRequestDto.getProfile() ) );
        user.setAdmin( userRequestDto.isAdmin() );

        return user;
    }
}
