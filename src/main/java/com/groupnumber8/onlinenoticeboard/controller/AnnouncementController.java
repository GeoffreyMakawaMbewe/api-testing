package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.service.AnnouncementServiceImplementation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/announcement")
public class AnnouncementController {
    //Injecting Announcement Service Implementation Class
    private final AnnouncementServiceImplementation announcementServiceImplementation;

    AnnouncementController(AnnouncementServiceImplementation announcementServiceImplementation){
        this.announcementServiceImplementation = announcementServiceImplementation;
    }
    @PostMapping(path = "/postNewAnnouncement")
    public ResponseEntity<AnnouncementDTO> newAnnouncement(@RequestBody AnnouncementDTO announcementDTO ){
        announcementServiceImplementation.postAnnouncement(announcementDTO);
        return  ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
