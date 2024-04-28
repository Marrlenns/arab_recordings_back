package com.example.arab_recording.controller;

import com.example.arab_recording.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/email")
public class EmailSenderController {

    private final EmailService emailService;

    @PostMapping("/admin_verification_mail/{email}")
    public void sendMail(@PathVariable String email) {
        emailService.sendActivationEmail(email);
    }

    @GetMapping("/admin_verification_confirm")
    public String confirm(@RequestParam String activationtoken) {
        emailService.confirm(activationtoken);
        return "Activation confirmed successfully";
    }

    @PostMapping("/expert_verification_mail/{email}")
    public void expertMail(@PathVariable String email) {
        emailService.expertMail(email);
    }

    @GetMapping("/expert_verification_confirm")
    public String expert_confirm(@RequestParam String activationtoken) {
        emailService.expert_confirm(activationtoken);
        return "Activation confirmed successfully";
    }
}
