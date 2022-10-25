package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnnouncementService {

    ResponseEntity<AnnouncementDTO> postAnnouncement(AnnouncementDTO announcementDTO);

    AnnouncementDTO fetchAnnouncementByName(String name);

    String enquireAnnouncementInfo();

    List<AnnouncementDTO> fetchAllAnnouncements();

    String updateAnnouncement(String name,AnnouncementDTO announcementDTO);
    String deleteAnnouncement(String name);
}
