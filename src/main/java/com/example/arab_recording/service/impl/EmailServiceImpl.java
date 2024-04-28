package com.example.arab_recording.service.impl;

import com.example.arab_recording.entities.User;
import com.example.arab_recording.enums.Role;
import com.example.arab_recording.repositories.UserRepository;
import com.example.arab_recording.service.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final UserRepository userRepository;


    public String generateActivationToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void sendActivationEmail(String email) {
        String activationtoken = generateActivationToken();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("aslan.tabaldiev@alatoo.edu.kg");
        message.setTo(email);
        message.setSubject("Activation Link for Your Admin Role");
        message.setText("Hello \n" +
                "Click on the following link to activate your admin account:\n\n" +
                "http://localhost:8081/email/verification_confirm?activationtoken=" + activationtoken + "\n\n" +
                "This link will expire in 24 hours.\n");

        mailSender.send(message);

        User user = userRepository.findUserByEmail(email);

        user.setActivationtoken(activationtoken);

        userRepository.save(user);
    }

    @Override
    public void confirm(String activationtoken) {
        User user = userRepository.findByActivationtoken(activationtoken);

        if(user != null) {
            user.setRole(Role.ADMIN);
            user.setActivationtoken(null);

            userRepository.save(user);
        }
    }

    @Override
    public void expertMail(String email) {
        String expert_token = generateActivationToken();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("aslan.tabaldiev@alatoo.edu.kg");
        message.setTo(email);
        message.setSubject("Activation link for your Expert role");
        message.setText("Hello \n" +
                "Click on the following link to activate your expert account:\n\n" +
                "http://localhost:8081/email/verification_confirm?activationtoken=" + expert_token + "\n\n" +
                "This link will expire in 24 hours.\n");

        mailSender.send(message);

        User user = userRepository.findUserByEmail(email);

        user.setActivationtoken(expert_token);

        userRepository.save(user);
    }

    @Override
    public void expert_confirm(String activationtoken) {
        User user = userRepository.findByActivationtoken(activationtoken);

        if(user != null) {
            user.setRole(Role.EXPERT);
            user.setActivationtoken(null);

            userRepository.save(user);
        }
    }
}
