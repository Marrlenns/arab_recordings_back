package com.example.arab_recording.dto;

import com.example.arab_recording.enums.Correctness;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PronunciationCheckRequest {
    private Long recordedWordId;
    private Correctness correctnessLevel;


}
