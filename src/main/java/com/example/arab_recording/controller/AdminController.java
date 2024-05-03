package com.example.arab_recording.controller;

import com.example.arab_recording.enums.Role;
import com.example.arab_recording.repositories.AdminRepository;
import com.example.arab_recording.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/expertRegistraton/{email}")
    public void expert_registration(@PathVariable String email, @RequestParam Role role) {
        adminService.expert_registration(email, role);
    }
}
