package com.example.arab_recording.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthLoginResponse {
    private Long id;
    private String email;
    private String nickName;
    private String token;
}
