package com.example.arab_recording.controller;

import com.example.arab_recording.dto.PronunciationCheckRequest;
import com.example.arab_recording.dto.ReportPronunciationRequest;
import com.example.arab_recording.enums.Correctness;
import com.example.arab_recording.service.ExpertService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@AllArgsConstructor
@RequestMapping("/expert")
public class ExpertController {
    private final ExpertService expertService;

    @GetMapping("/{id}")



    @PostMapping("/checkPronunciation")
    public ResponseEntity<String> checkPronunciation(@RequestBody PronunciationCheckRequest request) {
        Long recordedWordId = request.getRecordedWordId();
        Correctness correctnessLevel = request.getCorrectnessLevel();

        Correctness correctness  = expertService.assessPronunciation(recordedWordId, correctnessLevel);
        boolean assessmentSuccessful = expertService.assessWord(recordedWordId);

        if (assessmentSuccessful) {
            return ResponseEntity.ok("Pronunciation assessment completed successfully.");
        } else {
            return ResponseEntity.badRequest().body("Failed to assess pronunciation.");
        }
    }

    @DeleteMapping("/deleteRecordedWord/{recordedWordId}")
    public void deleteRecordedWord(@PathVariable Long recordedWordId) {
        expertService.deleteRecordedWord(recordedWordId);



    }
    @PostMapping("/report")
    public void reportPronunciation(@RequestBody ReportPronunciationRequest request ) {
        expertService.reportPronunciation(request);

    }
}

