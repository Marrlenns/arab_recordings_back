package com.example.arab_recording.controller;

import com.example.arab_recording.entities.Audio;
import com.example.arab_recording.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{email}/audio-count")
    public ResponseEntity<Integer> getAudioFileCountByStudent(@PathVariable String email) {
        int count = studentService.getAudioFileCountByStudentEmail(email);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/{email}/audioList")
    public ResponseEntity<List<Audio>> getAudioFilesByStudent(@PathVariable String email) {
        List<Audio> audioFiles = studentService.getAudioFilesByStudentEmail(email);
        return ResponseEntity.ok(audioFiles);
    }
}

