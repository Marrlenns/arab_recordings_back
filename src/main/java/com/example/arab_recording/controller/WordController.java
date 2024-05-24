package com.example.arab_recording.controller;

import com.example.arab_recording.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/word")
public class WordController {
    private final WordService wordService;

    @GetMapping("/get")
    public String getWord() {
        return wordService.getRandomWord();
    }
}
