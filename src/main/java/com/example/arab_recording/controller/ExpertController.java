package com.example.arab_recording.controller;

import com.example.arab_recording.dto.PronunciationCheckRequest;
import com.example.arab_recording.enums.Correctness;
import com.example.arab_recording.service.ExpertService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/expert")
public class ExpertController {
private final ExpertService expertService;


    @PostMapping("/checkPronunciation")
    public ResponseEntity<String> checkPronunciation(@RequestBody PronunciationCheckRequest request) {
        Long recordedWordId = request.getRecordedWordId();
        Correctness correctnessLevel = request.getCorrectnessLevel();

        boolean assessmentSuccessful = ExpertService.assessPronunciation(recordedWordId, correctnessLevel);

        if (assessmentSuccessful) {
            return ResponseEntity.ok("Pronunciation assessment completed successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to assess pronunciation.");
        }
    }


}

