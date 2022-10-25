package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AnnouncementService {

    ResponseEntity<AnnouncementDTO> postAnnouncement(AnnouncementDTO announcementDTO);
    Announcement fetchAnnouncementById(Long id);
    Announcement fetchAnnouncementByName(String name);
    String enquireAnnouncementInfo();
    List<Announcement> fetchAllAnnouncement();
    Announcement updateAnnouncement(Announcement announcement);
    Void deleteAnnouncement(Long id);
}
