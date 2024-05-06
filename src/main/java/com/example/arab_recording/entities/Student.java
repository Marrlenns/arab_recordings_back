package com.example.arab_recording.entities;

import com.example.arab_recording.enums.Gender;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "students_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickName;
    private Integer age;
    @Enumerated(EnumType.STRING)
    private Gender gender;

    private int wordsCount;
    private int monthRecord;

    @OneToOne(mappedBy = "student")
    private User user;
}