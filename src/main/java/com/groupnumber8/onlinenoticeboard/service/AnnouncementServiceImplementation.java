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
        //MAKE IT CARE INSENSITIVE
       Announcement announcement = announcementRepository.findAnnouncementByName(name).get();
       if (announcement.getName().equals(name)){
           //Converting to DTO
           var announcementDTO = new AnnouncementDTO();
           announcementDTO.setId(announcement.getId());
           announcementDTO.setName(announcement.getName());
           announcementDTO.setMessage(announcement.getMessage());
           announcementDTO.setPostedOn(announcement.getPostedOn());
           announcementDTO.setExpireOn(announcement.getExpireOn());
           //Return this
           return announcementDTO;
       }else {
           return null;
       }
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
    public String updateAnnouncement(String name,AnnouncementDTO announcementDTO  ) {
        Announcement announcement = new Announcement();
        announcement.setId(announcementDTO.getId());
        announcement.setName(announcementDTO.getName());
        announcement.setMessage(announcementDTO.getMessage());
        announcement.setPostedOn(announcementDTO.getPostedOn());
        announcement.setExpireOn(announcementDTO.getExpireOn());

        //Re-use Method FindBYName
       var targetAnnouncement =  announcementRepository.findAnnouncementByName(name).get();
       if (name != null&&name.equals(targetAnnouncement.getName())){
           targetAnnouncement.setName(announcement.getName());
           targetAnnouncement.setMessage(announcement.getMessage());
           targetAnnouncement.setPostedOn(announcement.getPostedOn());
           targetAnnouncement.setExpireOn(announcement.getExpireOn());
           announcementRepository.save(targetAnnouncement);
       }else {
           return "Make Sure you update the Announcement Name and an announcement must exist in the database";
       }
         return "Successful";
    }
    @Override
    public String deleteAnnouncement(String name) {
       var anouncement=  announcementRepository.findAnnouncementByName(name).get();
        announcementRepository.delete(anouncement);
        return "Deleted Announcement " + name;
    }
}
