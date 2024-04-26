package com.example.arab_recording.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter

    public class RecordedWord {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String word;

        @ManyToOne
        @JoinColumn(name = "recorded_by_id")
        private User recordedBy;

    }


