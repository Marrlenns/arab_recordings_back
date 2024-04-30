package com.example.arab_recording.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

//    @ManyToOne
//    @JoinColumn(name = "pronunciation_id", referencedColumnName = "id")
//    private Pronunciation pronunciation;

    @Column(name = "reason")
    private String reason;

}
