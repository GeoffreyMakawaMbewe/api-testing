package com.groupnumber8.onlinenoticeboard.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthoritiesContainer {

    private String authorityLevelOne = "STUDENT";
    private String authorityLevelTwo = "ADMIN";

}
