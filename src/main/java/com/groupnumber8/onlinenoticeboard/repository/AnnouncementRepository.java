package com.groupnumber8.onlinenoticeboard.repository;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AnnouncementRepository extends JpaRepository<Announcement, Long> {
    Optional<Announcement> findAnnouncementByName(String name);
     Announcement findAnnouncementById(Long id);
    List<Announcement> findAll();
}
