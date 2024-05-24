package com.example.arab_recording.service.impl;

import com.example.arab_recording.entities.Admin;
import com.example.arab_recording.entities.User;
import com.example.arab_recording.enums.Role;
import com.example.arab_recording.repositories.UserRepository;
import com.example.arab_recording.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JavaMailSender mailSender;

    public String generateActivationToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void expert_registration(String email, Role role) {
        Random random = new Random();
        String password = String.valueOf(random.nextInt(90000000) + 10000000);
        String activationtoken = generateActivationToken();

        User user = new User();

        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRole(Role.EXPERT);
        user.setActivationtoken(activationtoken);

        Admin admin=new Admin();
        admin.setNickName(user.getAdmin().getNickName());
        admin.setAge(user.getAdmin().getAge());
        admin.setUser(user);

        user.setAdmin(admin);

        userRepository.save(user);

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("aslan.tabaldiev@alatoo.edu.kg");
        message.setTo(email);
        message.setSubject("Your account");
        message.setText("Your email: " + email + "\n" +
                "Your password: " + password + "\n" +
                "Click to the link to login into your account: " +
                "http://localhost:8081/superadmin/account_confirm?activationtoken=" + activationtoken);

        mailSender.send(message);
    }
}
