package com.groupnumber8.onlinenoticeboard.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @JsonIgnore
    private int id;
    private String username;
   // @JsonIgnore
    private String password;
    private String role;
}
