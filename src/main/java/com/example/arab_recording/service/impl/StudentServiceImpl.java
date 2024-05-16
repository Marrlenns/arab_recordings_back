package com.example.arab_recording.service.impl;

import com.example.arab_recording.entities.Student;
import com.example.arab_recording.repositories.StudentRepository;
import com.example.arab_recording.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Value("${overall.record}")
    private int overallRecord;

    @Value("${monthly.record}")
    private int monthlyRecord;

    private LocalDate lastRecordDate = LocalDate.now();

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<Student> getStudentByEmail(String email) {
        return studentRepository.findByUserEmail(email);
    }

    @Override
    public int getWordsSpoken(String email) {
        Optional<Student> student = getStudentByEmail(email);
        return student.map(Student::getWordsSpoken).orElse(0);
    }

    public void incrementWordsSpoken(String email) {
        getStudentByEmail(email).ifPresent(student -> {
            int wordsSpoken = student.getWordsSpoken() + 1;
            student.setWordsSpoken(wordsSpoken);
            studentRepository.save(student);

            if (wordsSpoken > overallRecord) {
                overallRecord = wordsSpoken;
            }
            if (wordsSpoken > monthlyRecord && LocalDate.now().getMonthValue() == lastRecordDate.getMonthValue()) {
                monthlyRecord = wordsSpoken;
            } else if (LocalDate.now().getMonthValue() != lastRecordDate.getMonthValue()) {
                monthlyRecord = wordsSpoken;
                lastRecordDate = LocalDate.now();
            }
        });
    }
}

