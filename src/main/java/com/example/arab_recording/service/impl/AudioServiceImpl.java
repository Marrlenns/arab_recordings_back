package com.example.arab_recording.service.impl;

import com.example.arab_recording.entities.Audio;
import com.example.arab_recording.repositories.AudioRepository;
import com.example.arab_recording.repositories.StudentRepository;
import com.example.arab_recording.service.AudioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AudioServiceImpl implements AudioService {

    private AudioRepository audioFileRepository;


    public Audio saveAudioFile(MultipartFile file) throws IOException {
        Audio audioFile = new Audio();
        audioFile.setName(file.getOriginalFilename());
        audioFile.setBytes(file.getBytes());
        return audioFileRepository.save(audioFile);
    }

    public Optional<Audio> getAudioFile(Long id) {
        return audioFileRepository.findById(id);
    }
}
