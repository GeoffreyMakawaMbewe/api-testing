package com.groupnumber8.onlinenoticeboard.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Announcement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Date postedOn;

    @Column(nullable = false)
    private Date expireOn;
}
