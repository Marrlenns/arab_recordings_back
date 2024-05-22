package com.example.arab_recording.controller;

import com.example.arab_recording.dto.AuthLoginRequest;
import com.example.arab_recording.dto.AuthLoginResponse;
import com.example.arab_recording.dto.NewPasswordRequest;
import com.example.arab_recording.dto.UserRegisterRequest;
import com.example.arab_recording.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/registration_confirm")
    public String registration_confirm(@RequestParam String activationtoken) {
        authService.registration_confirm(activationtoken);
        return "Your account was successfully activated";
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
