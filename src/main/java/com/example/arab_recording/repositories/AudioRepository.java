package com.example.arab_recording.repositories;

import com.example.arab_recording.entities.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AudioRepository extends JpaRepository<Audio, Long> {

    List<Audio> findByStudentId(Long studentId);

    int countByStudentId(Long studentId);
}

