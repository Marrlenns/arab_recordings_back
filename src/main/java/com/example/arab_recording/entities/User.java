package com.example.arab_recording.entities;

import com.example.arab_recording.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "users_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String email;
    private String password;
    private Role role;
    private String activationtoken;


    @OneToOne(cascade = CascadeType.ALL)
    private Student student;

}
