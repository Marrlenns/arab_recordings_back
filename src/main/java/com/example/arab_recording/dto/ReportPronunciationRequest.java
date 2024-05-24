package com.example.arab_recording.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ReportPronunciationRequest {
    private Long recordedWordId;
    private String reportReason;
    private LocalDate reportedAt;

}
