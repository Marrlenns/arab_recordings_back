package com.example.arab_recording.service;

import com.example.arab_recording.entities.Audio;
import com.example.arab_recording.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    int getAudioFileCountByStudentEmail(String email);

    List<Audio> getAudioFilesByStudentEmail(String email);
}
