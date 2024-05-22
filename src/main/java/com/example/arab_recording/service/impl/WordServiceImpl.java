package com.example.arab_recording.service.impl;

import com.example.arab_recording.entities.Word;
import com.example.arab_recording.repositories.WordRepository;
import com.example.arab_recording.service.WordService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    @Override
    public String getRandomWord() {
        List<Word> words = wordRepository.findAll();
        int totalWords = words.size();

        if (totalWords == 0) {
            return null;
        }

        words.sort(Comparator.comparingInt(Word::getCounter));

        int threshold = totalWords / 3;  // Adjust this value to fine-tune the selection process
        List<Word> lessSpokenWords = words.subList(0, threshold);

        Random rand = new Random();
        return String.valueOf(lessSpokenWords.get(rand.nextInt(lessSpokenWords.size())));
    }
}
