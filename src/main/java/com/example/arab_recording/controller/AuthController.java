package com.example.arab_recording.controller;

import com.example.arab_recording.dto.AuthLoginRequest;
import com.example.arab_recording.dto.AuthLoginResponse;
import com.example.arab_recording.dto.NewPasswordRequest;
import com.example.arab_recording.dto.UserRegisterRequest;
import com.example.arab_recording.service.AuthService;
import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import org.hibernate.annotations.Struct;
import org.springframework.web.bind.annotation.*;
import com.example.arab_recording.service.AuthService;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public void register(UserRegisterRequest userRegisterRequest){
        authService.register(userRegisterRequest);
    }

    @PostMapping("/login")
    public AuthLoginResponse login(AuthLoginRequest authLoginRequest){
        return authService.login(authLoginRequest);
    }

    @PostMapping("/password_reset/{email}")
    public String password_reset(@PathVariable String email) {
        authService.password_reset(email);
        return "Your password reset code was sent";
    }

    @GetMapping("/password_confirm")
    public String password_confirm(@RequestBody NewPasswordRequest newPasswordRequest, @RequestParam Integer code) {
        authService.password_confirm(newPasswordRequest, code);
        return "Your password was updated";
    }
}
