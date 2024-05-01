package com.example.arab_recording.service;

import com.example.arab_recording.dto.ReportPronunciationRequest;
import com.example.arab_recording.enums.Correctness;

public interface ExpertService {

     Correctness assessPronunciation(Long recordedWordId, Correctness correctnessLevel);

    void deleteRecordedWord(Long recordedWordId);

    boolean assessWord(Long recordedWordId);


    void reportPronunciation(ReportPronunciationRequest request);

}
