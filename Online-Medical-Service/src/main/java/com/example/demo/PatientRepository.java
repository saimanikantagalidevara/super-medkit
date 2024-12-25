package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
