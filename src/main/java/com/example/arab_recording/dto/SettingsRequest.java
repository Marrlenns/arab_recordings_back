package com.example.arab_recording.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SettingsRequest {
    private Long id;

    private String playbackMode;

    private int loopedModePauseDuration;

    private String language;
}
