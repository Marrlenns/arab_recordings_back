package com.example.arab_recording.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "experts_table")
public class Expert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nickName;
    private Integer assessed_words;
    private Integer age;


    @OneToOne(mappedBy = "expert")
    private User user;
}
