package com.example.arab_recording.controller;

import com.example.arab_recording.dto.WordRequest;
import com.example.arab_recording.service.SuperAdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/superadmin")
public class SuperAdminController {

    private final SuperAdminService superAdminService;

    @PutMapping("/expert_role_remove/{email}")
    public void expert_role_remove(@PathVariable String email) {
        superAdminService.expert_role_remove(email);
    }

    @PostMapping("/add_word")
    public void addword(@RequestBody WordRequest wordRequest) {
        superAdminService.addword(wordRequest);
    }
}
