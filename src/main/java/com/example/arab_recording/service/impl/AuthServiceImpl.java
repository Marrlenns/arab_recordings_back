package com.example.arab_recording.service.impl;

import com.example.arab_recording.config.JwtService;
import com.example.arab_recording.dto.UserRegisterRequest;
import com.example.arab_recording.entities.User;
import com.example.arab_recording.exception.BadCredentialsException;
import com.example.arab_recording.repositories.UserRepository;
import com.example.arab_recording.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    private PasswordEncoder encoder;
    private AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    @Override
    public void register(UserRegisterRequest userRegisterRequest) {
        if (userRepository.findByEmail(userRegisterRequest.getEmail()).isPresent())
            throw new BadCredentialsException("user with email: "+userRegisterRequest.getEmail()+" is already exist!");

        User user = new User();
        user.setEmail(userRegisterRequest.getEmail());
        user.setPassword(encoder.encode(userRegisterRequest.getPassword()));
        userRepository.save(user);
    }
}
