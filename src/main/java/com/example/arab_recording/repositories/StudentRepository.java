package com.example.arab_recording.repositories;

import com.example.arab_recording.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
