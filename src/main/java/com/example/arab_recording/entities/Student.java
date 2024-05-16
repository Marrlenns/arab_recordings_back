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

    private Integer wordsSpoken;
    private Integer monthRecord;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AudioFile> audioFiles;
}