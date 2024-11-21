package com.cooksys.groupfinal.mappers;

import com.cooksys.groupfinal.dtos.AnnouncementDto;
import com.cooksys.groupfinal.dtos.AnnouncementRequestDto;
import com.cooksys.groupfinal.entities.Announcement;
import java.util.LinkedHashSet;
import java.util.List;
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
public class AnnouncementMapperImpl implements AnnouncementMapper {

    @Autowired
    private BasicUserMapper basicUserMapper;

    @Override
    public AnnouncementDto entityToDto(Announcement announcement) {
        if ( announcement == null ) {
            return null;
        }

        AnnouncementDto announcementDto = new AnnouncementDto();

        announcementDto.setId( announcement.getId() );
        announcementDto.setDate( announcement.getDate() );
        announcementDto.setTitle( announcement.getTitle() );
        announcementDto.setMessage( announcement.getMessage() );
        announcementDto.setAuthor( basicUserMapper.entityToBasicUserDto( announcement.getAuthor() ) );

        return announcementDto;
    }

    @Override
    public Set<AnnouncementDto> entitiesToDtos(Set<Announcement> announcement) {
        if ( announcement == null ) {
            return null;
        }

        Set<AnnouncementDto> set = LinkedHashSet.newLinkedHashSet( announcement.size() );
        for ( Announcement announcement1 : announcement ) {
            set.add( entityToDto( announcement1 ) );
        }

        return set;
    }

    @Override
    public Set<AnnouncementDto> entitiesToDtos(List<Announcement> announcement) {
        if ( announcement == null ) {
            return null;
        }

        Set<AnnouncementDto> set = LinkedHashSet.newLinkedHashSet( announcement.size() );
        for ( Announcement announcement1 : announcement ) {
            set.add( entityToDto( announcement1 ) );
        }

        return set;
    }

    @Override
    public Announcement dtoToEntity(AnnouncementRequestDto announcementRequestDto) {
        if ( announcementRequestDto == null ) {
            return null;
        }

        Announcement announcement = new Announcement();

        announcement.setTitle( announcementRequestDto.getTitle() );
        announcement.setMessage( announcementRequestDto.getMessage() );

        return announcement;
    }
}
