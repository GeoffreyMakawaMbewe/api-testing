package com.groupnumber8.onlinenoticeboard.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AnnouncementDTO {
    private Long id;
    private String name;
    private String message;
    private Date postedOn;
    private Date expireOn;
}
