package com.example.arab_recording.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportPronunciationRequest {
    private Long recordedWordId;
    private String reportReason;

}
