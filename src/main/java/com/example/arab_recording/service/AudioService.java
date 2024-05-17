package com.example.arab_recording.service;

import com.example.arab_recording.entities.Audio;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

public interface AudioService {

    Optional<Audio> getAudioFile(Long id);

    Audio saveAudioFile(MultipartFile file) throws IOException;
}
