package com.example.arab_recording.service;

import com.example.arab_recording.enums.Correctness;

public interface ExpertService {

     Correctness assessPronunciation(Long recordedWordId, Correctness correctnessLevel);

    void deleteRecordedWord(Long recordedWordId);

    boolean assessWord(Long recordedWordId);

    String reportPronunciation(Long recordedWordId, String reportReason);
}
