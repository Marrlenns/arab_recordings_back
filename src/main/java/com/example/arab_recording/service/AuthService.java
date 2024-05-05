package com.example.arab_recording.service;

import com.example.arab_recording.dto.AuthLoginRequest;
import com.example.arab_recording.dto.AuthLoginResponse;
import com.example.arab_recording.dto.NewPasswordRequest;
import com.example.arab_recording.dto.UserRegisterRequest;
import com.example.arab_recording.entities.User;

import java.util.Optional;

public interface AuthService {
    void register(UserRegisterRequest userRegisterRequest);

    void registration_confirm(String activationtoken);

    AuthLoginResponse login(AuthLoginRequest authLoginRequest);

    void password_reset(String email);

    void password_confirm(NewPasswordRequest newPasswordRequest, Integer code);

    AuthLoginResponse convertToResponse(Optional<User> user);

    User getUsernameFromToken(String token);
}
