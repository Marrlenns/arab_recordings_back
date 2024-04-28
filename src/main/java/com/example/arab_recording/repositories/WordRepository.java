package com.example.arab_recording.repositories;

import com.example.arab_recording.entities.Word;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRepository extends JpaRepository<Word, Long> {
}
