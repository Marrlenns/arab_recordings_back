package com.example.arab_recording.repositories;

import com.example.arab_recording.entities.Word;
import com.example.arab_recording.enums.Level;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WordRepository extends JpaRepository<Word, Long> {

    Optional<Word> findByWord(String word);

    long countByLevel(Level level);
}
