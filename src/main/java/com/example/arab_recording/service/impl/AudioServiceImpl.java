package com.example.arab_recording.service.impl;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.example.arab_recording.entities.Audio;
import com.example.arab_recording.entities.Student;
import com.example.arab_recording.entities.Word;
import com.example.arab_recording.exception.NotFoundException;
import com.example.arab_recording.repositories.AudioRepository;
import com.example.arab_recording.repositories.StudentRepository;
import com.example.arab_recording.repositories.WordRepository;
import com.example.arab_recording.service.AudioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.services.s3.endpoints.internal.Value;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
@AllArgsConstructor
public class AudioServiceImpl implements AudioService {

    private final AudioRepository audioRepository;
    private final StudentRepository studentRepository;
    private final AmazonS3 amazonS3;
    private final WordRepository wordRepository;

    private final String bucketName = "your-bucket-name";

    @Override
    public Audio saveAudioFile(MultipartFile file, String email, Long wordId) throws IOException {
        Optional<Student> studentOptional = studentRepository.findByUserEmail(email);
        if (studentOptional.isPresent()) {
            String key = "audio/" + UUID.randomUUID() + "-" + file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            amazonS3.putObject(bucketName, key, inputStream, metadata);

            Audio audioFile = new Audio();
            audioFile.setName(file.getOriginalFilename());
            audioFile.setUrl(amazonS3.getUrl(bucketName, key).toString());
            audioFile.setStudent(studentOptional.get());

            Optional<Word> word = wordRepository.findById(wordId);
            if(word.isPresent()) {
                Integer wordCount = word.get().getCounter();
                word.get().setCounter(wordCount + 1);
                wordRepository.save(word.get());
            }
            else {
                throw new NotFoundException("Word is not found", HttpStatus.NOT_FOUND);
            }

            return audioRepository.save(audioFile);
        } else {
            throw new IllegalArgumentException("Student not found");
        }
    }

    @Override
    public Optional<Audio> getAudioFile(Long id) {
        return audioRepository.findById(id);
    }
}
