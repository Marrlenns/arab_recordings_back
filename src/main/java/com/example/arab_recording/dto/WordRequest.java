package com.example.arab_recording.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WordRequest {

    private String word;
    private String translation;
    private String transcription;
    private String level;
}
