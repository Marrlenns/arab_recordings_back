package com.example.arab_recording.service;

import com.example.arab_recording.dto.AuthLoginRequest;
import com.example.arab_recording.dto.AuthLoginResponse;
import com.example.arab_recording.dto.UserRegisterRequest;
import com.example.arab_recording.entities.User;

public interface AuthService {
    void register(UserRegisterRequest userRegisterRequest);
}
