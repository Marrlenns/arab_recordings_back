package com.example.arab_recording.service.impl;

import com.example.arab_recording.entities.Audio;
import com.example.arab_recording.entities.Student;
import com.example.arab_recording.repositories.AudioRepository;
import com.example.arab_recording.repositories.StudentRepository;
import com.example.arab_recording.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final AudioRepository audioRepository;

    @Override
    public int getAudioFileCountByStudentEmail(String email) {
        Optional<Student> studentOptional = studentRepository.findByUserEmail(email);
        return studentOptional.map(student -> audioRepository.countByStudentId(student.getId())).orElse(0);
    }

    @Override
    public List<Audio> getAudioFilesByStudentEmail(String email) {
        Optional<Student> studentOptional = studentRepository.findByUserEmail(email);
        return studentOptional.map(student -> audioRepository.findByStudentId(student.getId())).orElse(null);
    }
}
