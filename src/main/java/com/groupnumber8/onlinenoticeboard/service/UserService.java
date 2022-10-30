package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.entities.SecurityUser;
import com.groupnumber8.onlinenoticeboard.entities.User;
import com.groupnumber8.onlinenoticeboard.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(username);

        SecurityUser securityUser = new SecurityUser(user);
        return securityUser;
    }
}
