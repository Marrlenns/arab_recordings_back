package com.example.arab_recording.dto;

import com.example.arab_recording.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterRequest {

    private String email;
    private String nickName;
    private String password;
    private Integer age;
    private Gender gender;
}