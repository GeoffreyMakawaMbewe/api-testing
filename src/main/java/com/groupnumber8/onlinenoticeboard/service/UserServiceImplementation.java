package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.DTO.UserDTO;
import com.groupnumber8.onlinenoticeboard.entities.SecurityUser;
import com.groupnumber8.onlinenoticeboard.entities.User;
import com.groupnumber8.onlinenoticeboard.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements  UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserServiceImplementation(PasswordEncoder passwordEncoder, UserRepository userRepository ) {
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
    @Override
    public void registerNewUser(UserDTO userDTO) {
         User user = new User();
         user.setUsername(userDTO.getUsername());
         user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
         user.setRole(userDTO.getRole());
        userRepository.save(user);
    }
    @Override
    public List<User> allSystemUsers() {
        //TODO: Map each user in the list to DTO & Convert each DTO to a LIst ==> Return this List of DTOs
        return userRepository.findAll();
    }

    @Override
    public UserDTO findUserByUserName(String username) {
        User user = userRepository.findUserByUsername(username);
        return  new UserDTO(user.getUsername(),user.getPassword(),user.getRole());
    }

    @Override
    public void updateUserDetails(String username, UserDTO userDTO) {
    }
    @Override
    public void deleteUserByUserName(String username) {
        User userToDelete = userRepository.findUserByUsername(username);
        if (userToDelete != null){
            userRepository.deleteByUsername(username);
        }

    }

}
