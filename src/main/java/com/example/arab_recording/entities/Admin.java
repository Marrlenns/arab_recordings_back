package com.example.arab_recording.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "admins_table")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickName;
    private Integer age;

    @OneToOne(mappedBy = "admin")
    private User user;
}
