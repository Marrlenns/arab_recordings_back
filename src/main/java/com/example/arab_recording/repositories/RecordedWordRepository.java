package com.example.arab_recording.repositories;

import com.example.arab_recording.entities.RecordedWord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordedWordRepository extends JpaRepository <RecordedWord,Long> {
}
