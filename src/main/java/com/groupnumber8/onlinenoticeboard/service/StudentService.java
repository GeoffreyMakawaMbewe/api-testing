package com.groupnumber8.onlinenoticeboard.service;

import com.groupnumber8.onlinenoticeboard.entities.Student;
import com.groupnumber8.onlinenoticeboard.repository.StudentRepository;
import com.groupnumber8.onlinenoticeboard.security.SecurityStudent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class StudentService implements UserDetailsService {

    //Injecting Student Repository
    private final StudentRepository studentRepository;
    StudentService(StudentRepository studentRepository){
        this.studentRepository= studentRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username)  {

        Optional<Student> student = studentRepository.findStudentByUsername(username);

        Student foundStudent = student.orElseThrow( () -> new  UsernameNotFoundException("No Student With Username " + username + " Was Found"));
        System.out.println(student.toString());
        return new SecurityStudent(foundStudent);
    }
}
