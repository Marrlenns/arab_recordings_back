package com.example.arab_recording.repositories;

import com.example.arab_recording.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
