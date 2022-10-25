package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.entities.Announcement;

import java.util.List;

public interface AnnouncementService {

    Announcement postAnnouncement(Announcement announcement);
    Announcement fetchAnnouncementById(Long id);
    Announcement fetchAnnouncementByName(String name);
    String enquireAnnouncementInfo();
    List<Announcement> fetchAllAnnouncement();
    Announcement updateAnnouncement(Announcement announcement);
    Void deleteAnnouncement(Long id);
}
