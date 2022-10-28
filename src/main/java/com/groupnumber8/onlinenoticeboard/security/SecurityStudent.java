package com.groupnumber8.onlinenoticeboard.security;

import com.groupnumber8.onlinenoticeboard.config.RolesContainer;
import com.groupnumber8.onlinenoticeboard.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SecurityStudent implements UserDetails {

    private final Student student;
    @Autowired
    private RolesContainer rolesContainer;

    public SecurityStudent(Student student) {
        this.student = student;
    }

    //SET OF AUTHORITIES FOR STUDENT
    SimpleGrantedAuthority authorities = new SimpleGrantedAuthority(rolesContainer.getRoleLevelOne());

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(authorities);
        return grantedAuthorities ;
    }


    @Override
    public String getPassword() {
        return student.getPassword();
    }

    @Override
    public String getUsername() {
        return student.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
