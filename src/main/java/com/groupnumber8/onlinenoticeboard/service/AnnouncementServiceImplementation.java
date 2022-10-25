package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImplementation implements AnnouncementService{
    @Override
    public ResponseEntity<Announcement> postAnnouncement(Announcement announcement) {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public Announcement fetchAnnouncementById(Long id) {
        return null;
    }

    @Override
    public Announcement fetchAnnouncementByName(String name) {
        return null;
    }

    @Override
    public String enquireAnnouncementInfo() {
        return null;
    }

    @Override
    public List<Announcement> fetchAllAnnouncement() {
        return null;
    }

    @Override
    public Announcement updateAnnouncement(Announcement announcement) {
        return null;
    }

    @Override
    public Void deleteAnnouncement(Long id) {
        return null;
    }
}
