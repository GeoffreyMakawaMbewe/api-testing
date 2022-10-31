package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.entities.SecurityUser;
import com.groupnumber8.onlinenoticeboard.entities.User;
import com.groupnumber8.onlinenoticeboard.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {


    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository ) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.findUserByUsername(username);
        SecurityUser securityUser = new SecurityUser(user);
        if (user == null){
            throw new UsernameNotFoundException("User not found");
        }
            return securityUser;

    }

    public User registerNewUser(User user) {
        String EncodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(EncodedPassword);
        return userRepository.save(user);
    }
}
