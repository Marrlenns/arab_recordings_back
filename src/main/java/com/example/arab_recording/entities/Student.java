package com.example.arab_recording.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "students_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String LastName;
    private int age;

    private int wordsCount;
    private int monthRecord;


    @OneToOne(mappedBy = "student")
    private User user;
}