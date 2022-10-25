package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.AnnouncementDTO;
import com.groupnumber8.onlinenoticeboard.entities.Announcement;
import com.groupnumber8.onlinenoticeboard.repository.AnnouncementRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnnouncementServiceImplementation implements AnnouncementService{
    private final AnnouncementRepository announcementRepository;
    AnnouncementServiceImplementation(AnnouncementRepository announcementRepository ){
        this.announcementRepository = announcementRepository;
    }
    @Override
    public ResponseEntity<AnnouncementDTO> postAnnouncement(AnnouncementDTO announcementDTO) {
        //Check For NoNull Object
       // if (!announcementDTO.getName().isBlank()&&announcementDTO.getMessage().isEmpty()&&announcementDTO.getPostedOn().after(announcementDTO.getExpireOn())) {
            //Mapping DTO to Entity
            Announcement announcement = new Announcement();
            announcement.setId(announcementDTO.getId());
            announcement.setName( announcementDTO.getName());
            announcement.setMessage(announcementDTO.getMessage() );
            announcement.setPostedOn( announcementDTO.getPostedOn());
            announcement.setExpireOn(announcementDTO.getExpireOn() );
            //Now Save The Entity to DB
            announcementRepository.save(announcement);
            return ResponseEntity.status(HttpStatus.CREATED).build();
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
        List<Announcement> announcementList = announcementRepository.findAll();
        List<AnnouncementDTO> announcementDTOList = new ArrayList<>();
        for (Announcement announcement: announcementList) {
            AnnouncementDTO myAnnouncementDTO = new AnnouncementDTO();
            myAnnouncementDTO.setId(announcement.getId());
            myAnnouncementDTO.setName(announcement.getName());
            myAnnouncementDTO.setMessage(announcement.getMessage());
            myAnnouncementDTO.setPostedOn(announcement.getPostedOn());
            myAnnouncementDTO.setExpireOn(announcement.getExpireOn());
            //Add Every DTO to DTO list
            announcementDTOList.add(myAnnouncementDTO);
        }
        return announcementDTOList ;
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
