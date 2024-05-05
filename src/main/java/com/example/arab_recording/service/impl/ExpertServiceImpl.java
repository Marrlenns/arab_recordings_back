package com.example.arab_recording.service.impl;

import com.example.arab_recording.dto.ReportPronunciationRequest;
import com.example.arab_recording.dto.SettingsRequest;
import com.example.arab_recording.entities.ExpertSettings;
import com.example.arab_recording.entities.RecordedWord;
import com.example.arab_recording.entities.Report;
import com.example.arab_recording.enums.Correctness;
import com.example.arab_recording.repositories.ExpertRepository;
import com.example.arab_recording.repositories.ExpertSettingsRepository;
import com.example.arab_recording.repositories.RecordedWordRepository;
import com.example.arab_recording.repositories.ReportRepository;
import com.example.arab_recording.service.ExpertService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;



@Service
@AllArgsConstructor
public class ExpertServiceImpl implements ExpertService {
    private final RecordedWordRepository recordedWordRepository;
    private final ReportRepository reportRepository;
    private final ExpertRepository expertRepository;
    private final ExpertSettingsRepository expertSettingsRepository;


    @Override
    public Correctness assessPronunciation(Long recordedWordId, Correctness correctnessLevel) {
        String correctness = correctnessLevel.toString();
        return switch (correctness) {
            case "CORRECT" -> correctnessLevel.CORRECT;
            case "CORRECT-WITHOUT-TAJWEED" -> correctnessLevel.CORRECTWITHOUTTAJWEED;
            case "INCORRECT" -> correctnessLevel.INCORRECT;
            default -> correctnessLevel.INCORRECT;

        };

    }


    @Override
    public void deleteRecordedWord(Long recordedWordId) {
        expertRepository.deleteById(recordedWordId);


    }

    @Override
    public boolean assessWord(Long recordedWordId) {
        return false;
    }

    public void reportPronunciation(ReportPronunciationRequest request) {
        RecordedWord recordedWord = recordedWordRepository.findById(request.getRecordedWordId())
                .orElseThrow(() -> new EntityNotFoundException("Recorded word not found with id: " + request.getRecordedWordId()));

        Report report = new Report();
        report.setRecordedWord(recordedWord);
        report.setReportReason(request.getReportReason());
        report.setReportedAt(request.getReportedAt());

        reportRepository.save(report);
    }

    @Override
    public ExpertSettings getExpertSettings() {
        return expertSettingsRepository.findById(1L)
                .orElseThrow(() -> new EntityNotFoundException("Expert settings not found"));
    }

    @Override
    public void updateExpertSettings(SettingsRequest request) {
            ExpertSettings settings = expertSettingsRepository.findById(1L)
                    .orElse(new ExpertSettings());

            settings.setPlaybackMode(request.getPlaybackMode());
            settings.setLoopedModePauseDuration(request.getLoopedModePauseDuration());
            settings.setLanguage(request.getLanguage());

            expertSettingsRepository.save(settings);

    }

}







