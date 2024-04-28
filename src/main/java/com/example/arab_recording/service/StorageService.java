package com.example.arab_recording.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    String uploadFile(MultipartFile file);

    byte[] downloadFile(String fileName);

    void deleteFile(String fileName);
}