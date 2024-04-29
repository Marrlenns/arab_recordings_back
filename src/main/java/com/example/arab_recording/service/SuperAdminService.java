package com.example.arab_recording.service;

import com.example.arab_recording.dto.WordRequest;
import com.example.arab_recording.enums.Role;

public interface SuperAdminService {
    void expert_role_remove(String email);

    void addword(WordRequest wordRequest);

    void account_registration(String email, Role role);

    void account_confirm(String activationtoken);
}
