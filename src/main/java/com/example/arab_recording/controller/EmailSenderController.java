package com.example.arab_recording.controller;

import com.example.arab_recording.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class EmailSenderController {

    private final EmailService emailService;

    @PostMapping("/verification_mail/{email}")
    public void sendMail(@PathVariable String email) {
        emailService.sendActivationEmail(email);
    }

    @GetMapping("/verification_confirm")
    public String confirm(@RequestParam String activationtoken) {
        emailService.confirm(activationtoken);
        return "Activation confirmed successfully";
    }
}
