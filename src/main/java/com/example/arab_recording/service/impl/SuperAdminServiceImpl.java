package com.example.arab_recording.service.impl;

import com.example.arab_recording.dto.WordRequest;
import com.example.arab_recording.entities.User;
import com.example.arab_recording.entities.Word;
import com.example.arab_recording.enums.Level;
import com.example.arab_recording.enums.Role;
import com.example.arab_recording.repositories.UserRepository;
import com.example.arab_recording.repositories.WordRepository;
import com.example.arab_recording.service.SuperAdminService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {

    private final UserRepository userRepository;
    private final WordRepository wordRepository;
    private final PasswordEncoder encoder;
    private final JavaMailSender mailSender;

    public String generateActivationToken() {
        return UUID.randomUUID().toString();
    }

    @Override
    public void expert_role_remove(String email) {
        User user = userRepository.findUserByEmail(email);

        user.setRole(Role.STUDENT);

        userRepository.save(user);
    }

    @Override
    public void addword(WordRequest wordRequest) {
        if(wordRepository.findByWord(wordRequest.getWord()).isEmpty()) {
            Word word = new Word();

            word.setWord(wordRequest.getWord());
            word.setLevel(Level.valueOf(wordRequest.getLevel()));

            wordRepository.save(word);
        }
        else {
            throw new BadCredentialsException("Word is already exist");
        }
    }

    @Override
    public void account_registration(String email, Role role) {
        Random random = new Random();
        String password = String.valueOf(random.nextInt(90000000) + 10000000);
        String activationtoken = generateActivationToken();

        User user = new User();

        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRole(role);
        user.setActivationtoken(activationtoken);

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



    @Override
    public void account_confirm(String activationtoken) {
        User user = userRepository.findByActivationtoken(activationtoken);

        if(user != null) {
            user.setActivationtoken("Active");

            userRepository.save(user);
        }
    }
}
