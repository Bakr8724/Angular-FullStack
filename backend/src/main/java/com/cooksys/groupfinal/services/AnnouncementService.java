package com.cooksys.groupfinal.services;

import com.cooksys.groupfinal.dtos.AnnouncementDto;
import com.cooksys.groupfinal.dtos.AnnouncementRequestDto;

import java.util.Set;

public interface AnnouncementService {

    AnnouncementDto createAnnouncement(AnnouncementRequestDto announcementRequestDto, Long companyId, Long userId);

}