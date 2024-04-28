package com.example.arab_recording.service;

import com.example.arab_recording.enums.Correctness;

public interface ExpertService {

     Correctness assessPronunciation(Long recordedWordId, Correctness correctnessLevel);

    boolean deleteRecordedWord(Long recordedWordId);

    boolean assessWord(Long recordedWordId);
}
