package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Patient;
import com.example.demo.Appointment;
import com.example.demo.PatientRepository;
import com.example.demo.AppointmentRepository;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class DoctorController {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    // Get all patients
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    // Get all appointments
    @GetMapping("/doctor/appointments")
    public List<Appointment> getAllDoctorAppointments() {
        return appointmentRepository.findAll();
    }
}
