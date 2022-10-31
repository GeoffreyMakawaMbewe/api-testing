package com.groupnumber8.onlinenoticeboard.controller;

import com.groupnumber8.onlinenoticeboard.entities.User;
import com.groupnumber8.onlinenoticeboard.repository.UserRepository;
import com.groupnumber8.onlinenoticeboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
         return "Hello";
     }

     @PostMapping("/register")
     public User registerUser(@RequestBody User user){
        return  userService.registerNewUser(user);
     }
     @GetMapping("/logged")
    public String loggenInUser( ){

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // String password = authentication.getCredentials().toString();
         System.out.println(username);
         String details = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getDetails());
         System.out.println(details);
        return "loggedUser is " + username + " \nand password is \n" ;
     }
     @GetMapping("/users")
    public List<User> getAll(){
        return userRepository.findAll();
     }


}
