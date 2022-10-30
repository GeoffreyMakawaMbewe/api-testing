package com.groupnumber8.onlinenoticeboard.repository;

import com.groupnumber8.onlinenoticeboard.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

     User findUserByUsername(String username);
}
