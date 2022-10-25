package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import com.groupnumber8.onlinenoticeboard.repository.AnnouncementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AnnouncementServiceImplementation implements AnnouncementService{

    private final AnnouncementRepository announcementRepository;
    AnnouncementServiceImplementation(AnnouncementRepository announcementRepository){
        this.announcementRepository = announcementRepository;
    }

    @Override
    public ResponseEntity<AnnouncementDTO> postAnnouncement(AnnouncementDTO announcementDTO) {
        //Check For NoNull Object
       // if (!announcementDTO.getName().isBlank()&&announcementDTO.getMessage().isEmpty()&&announcementDTO.getPostedOn().after(announcementDTO.getExpireOn())) {
            //Mapping DTO to Entity
            AnnouncementDTO newAnnouncementDTO = new AnnouncementDTO();
            Announcement announcement = new Announcement();
            announcement.setId(newAnnouncementDTO.getId());
            announcement.setName(newAnnouncementDTO.getName());
            announcement.setMessage(newAnnouncementDTO.getMessage());
            announcement.setPostedOn(newAnnouncementDTO.getPostedOn());
            announcement.setExpireOn(newAnnouncementDTO.getExpireOn());

            //Now Save The Entity to DB
            announcementRepository.save(announcement);

            return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @Override
    public AnnouncementDTO fetchAnnouncementById(Long id) {
        return null;
    }

    @Override
    public AnnouncementDTO fetchAnnouncementByName(String name) {
        return null;
    }

    @Override
    public String enquireAnnouncementInfo() {
        return null;
    }

    @Override
    public List<AnnouncementDTO> fetchAllAnnouncements() {

        return null;
    }

    @Override
    public AnnouncementDTO updateAnnouncement(AnnouncementDTO announcementDTO  ) {
        return null;
    }

    @Override
    public Void deleteAnnouncement(Long id) {
        return null;
    }
}
