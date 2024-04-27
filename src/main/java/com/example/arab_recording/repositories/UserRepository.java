package com.example.arab_recording.repositories;

import com.example.arab_recording.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    //for admin and expert registration
    User findByActivationtoken(String activationtoken);
    User findUserByEmail(String email);
}
