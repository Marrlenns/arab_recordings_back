package com.example.arab_recording.entities;

import com.example.arab_recording.enums.Level;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String word;
    private Level level;
    private Integer counter;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Audio> word_audios;
}
