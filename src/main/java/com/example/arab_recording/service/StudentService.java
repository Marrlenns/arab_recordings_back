package com.example.arab_recording.service;

public interface StudentService {
    int getWordsSpoken(String email);

    void incrementWordsSpoken(String email);
}
