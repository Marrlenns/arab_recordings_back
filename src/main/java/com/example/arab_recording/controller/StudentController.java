package com.example.arab_recording.controller;

import com.example.arab_recording.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{name}/words")
    public int getWordsSpoken(@PathVariable String email) {
        return studentService.getWordsSpoken(email);
    }
}
