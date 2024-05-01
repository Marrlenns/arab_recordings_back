package com.example.arab_recording.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "expert_id", referencedColumnName = "id")
    private User expert; // Expert who reported the pronunciation



    @Column(name = "reason")
    private String reportReason;
    @Column(name = "reported_date")
    private LocalDate reportedAt;

    @ManyToOne
    @JoinColumn(name = "recorded_word")
    private RecordedWord recordedWord;

}
