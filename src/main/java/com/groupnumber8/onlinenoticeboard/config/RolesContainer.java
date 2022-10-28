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
public class RolesContainer {

    private String roleLevelOne = "STUDENT";
    private String roleLevelTwo = "STAFF";

}
