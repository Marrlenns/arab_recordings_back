package com.example.arab_recording.service;

import com.example.arab_recording.enums.Correctness;

public interface ExpertService {
    static boolean assessPronunciation(Long recordedWordId, Correctness correctnessLevel) {
        return true;
    }
}
