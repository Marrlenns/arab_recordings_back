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
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SuperAdminServiceImpl implements SuperAdminService {

    private final UserRepository userRepository;
    private final WordRepository wordRepository;

    @Override
    public void expert_role_remove(String email) {
        User user = userRepository.findUserByEmail(email);

        user.setRole(Role.STUDENT);

        userRepository.save(user);
    }

    @Override
    public void addword(WordRequest wordRequest) {
        Word word = new Word();

        word.setWord(wordRequest.getWord());
        word.setLevel(Level.valueOf(wordRequest.getLevel()));

        wordRepository.save(word);
    }
}
