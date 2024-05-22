package com.example.arab_recording.service;

import com.example.arab_recording.entities.Audio;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AudioService {
    Audio saveAudioFile(MultipartFile file, String email, Long wordId) throws IOException;

    Optional<Audio> getAudioFile(Long id);
}

