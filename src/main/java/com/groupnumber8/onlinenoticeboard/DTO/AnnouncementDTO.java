package com.groupnumber8.onlinenoticeboard.DTO;

import lombok.*;
import org.springframework.stereotype.Component;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class AnnouncementDTO {
    private Long id;
    private String name;
    private String message;
    private String postedOn;
    private String expireOn;
}
