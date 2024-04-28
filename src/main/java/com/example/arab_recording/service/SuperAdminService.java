package com.example.arab_recording.service;

import com.example.arab_recording.dto.WordRequest;

public interface SuperAdminService {
    void expert_role_remove(String email);

    void addword(WordRequest wordRequest);
}
