package com.example.arab_recording.repositories;

import com.example.arab_recording.entities.Audio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AudioRepository extends JpaRepository<Audio, Long> {

}
