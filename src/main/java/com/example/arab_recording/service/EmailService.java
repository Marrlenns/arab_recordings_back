package com.example.arab_recording.service;

public interface EmailService {

    void sendActivationEmail(String email);

    void confirm(String activationtoken);

    void expertMail(String email);

    void expert_confirm(String activationtoken);
}
