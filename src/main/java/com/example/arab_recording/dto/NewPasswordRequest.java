package com.example.arab_recording.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewPasswordRequest {

    private String new_password;
    private String new_password_confirm;
}
