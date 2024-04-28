package com.example.arab_recording.entities;

import com.example.arab_recording.enums.Correctness;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Assessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recorded_word_id")
    private RecordedWord recordedWord;

    @ManyToOne
    @JoinColumn(name = "expert_id")
    private Expert expert;

    @Enumerated(EnumType.STRING)
    private Correctness correctnessLevel;


}