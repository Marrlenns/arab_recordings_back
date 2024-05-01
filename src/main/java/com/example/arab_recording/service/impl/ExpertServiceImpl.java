package com.example.arab_recording.service.impl;

import com.example.arab_recording.enums.Correctness;
import com.example.arab_recording.service.ExpertService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ExpertServiceImpl implements ExpertService {

    @Override
    public Correctness assessPronunciation(Long recordedWordId, Correctness correctnessLevel) {
        String Correctness = correctnessLevel.toString();
        return switch (Correctness) {
            case "CORRECT" -> correctnessLevel.CORRECT;
            case "CORRECT-WITHOUT-TAJWEED" -> correctnessLevel.CORRECTWITHOUTTAJWEED;
            case "INCORRECT" -> correctnessLevel.INCORRECT;
            default -> correctnessLevel.INCORRECT;

        };

    }


    @Override
    public boolean deleteRecordedWord(Long recordedWordId) {
        return false;
    }

    @Override
    public boolean assessWord(Long recordedWordId) {
        return false;
    }
}
