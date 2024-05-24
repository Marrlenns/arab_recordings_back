package com.example.arab_recording.repositories;

import com.example.arab_recording.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository <Report,Long> {
}
