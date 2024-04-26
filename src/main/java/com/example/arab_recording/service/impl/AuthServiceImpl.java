package com.example.arab_recording.service.impl;

import com.example.arab_recording.config.JwtService;
import com.example.arab_recording.dto.AuthLoginRequest;
import com.example.arab_recording.dto.AuthLoginResponse;
import com.example.arab_recording.dto.UserRegisterRequest;
import com.example.arab_recording.entities.Student;
import com.example.arab_recording.entities.User;
import com.example.arab_recording.enums.Role;
import com.example.arab_recording.exception.BadCredentialsException;
import com.example.arab_recording.repositories.UserRepository;
import com.example.arab_recording.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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
        user.setRole(Role.STUDENT);
        user.setPassword(encoder.encode(userRegisterRequest.getPassword()));
        Student student=new Student();
        student.setFirstName(userRegisterRequest.getFirstName());
        student.setLastName(userRegisterRequest.getLastName());
        student.setAge(userRegisterRequest.getAge());
        student.setUser(user);
        user.setStudent(student);
        userRepository.save(user);
    }

    @Override
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest) {
        Optional<User> user = userRepository.findByEmail(authLoginRequest.getEmail());
        if (user.isEmpty())
            throw new BadCredentialsException("user not found");

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authLoginRequest.getEmail(),authLoginRequest.getPassword()));

        }catch (org.springframework.security.authentication.BadCredentialsException e){
            throw new BadCredentialsException("user not found");
        }


        return convertToResponse(user);
    }

    private AuthLoginResponse convertToResponse(Optional<User> user) {
        AuthLoginResponse authLoginResponse = new AuthLoginResponse();
        authLoginResponse.setEmail(user.get().getEmail());
        authLoginResponse.setId(user.get().getId());
        if (user.get().getRole().equals(Role.STUDENT))
            authLoginResponse.setFirstName(user.get().getStudent().getFirstName());
            authLoginResponse.setLastName(user.get().getStudent().getLastName());
        Map<String, Object> extraClaims = new HashMap<>();

        String token = jwtService.generateToken(extraClaims, (UserDetails) user.get());
        authLoginResponse.setToken(token);

        return authLoginResponse;
    }
}
