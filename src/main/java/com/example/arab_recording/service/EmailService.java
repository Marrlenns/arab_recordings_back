package com.example.arab_recording.service;

public interface EmailService {

    void sendActivationEmail(String email);

    void confirm(String activationtoken);
}
