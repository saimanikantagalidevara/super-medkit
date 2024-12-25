package com.example.demo;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/appointments")
    public ResponseEntity<String> bookAppointment(@RequestBody Appointment appointment) {
        System.out.println("Received appointment: " + appointment);
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok("Appointment booked successfully");
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PutMapping("/appointments/{id}")
    public ResponseEntity<Appointment> updateAppointmentStatus(
            @PathVariable Long id, 
            @RequestBody Map<String, String> request) {
        return appointmentRepository.findById(id)
                .map(appointment -> {
                    appointment.setStatus(request.get("status"));
                    appointmentRepository.save(appointment);
                    return ResponseEntity.ok(appointment);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/prescriptions/{id}")
    public ResponseEntity<String> updatePrescription(
            @PathVariable("id") Long appointmentId,
            @RequestBody Map<String, String> requestBody) {
        System.out.println("Updating Prescription for Appointment ID: " + appointmentId);
        System.out.println("Received Prescription: " + requestBody);

        Optional<Appointment> optionalAppointment = appointmentRepository.findById(appointmentId);
        if (optionalAppointment.isPresent()) {
            Appointment appointment = optionalAppointment.get();
            String prescription = requestBody.get("prescription");
            
            if (prescription == null || prescription.isEmpty()) {
                return ResponseEntity.badRequest().body("Prescription content is missing.");
            }
            
            // Update prescription field as per your frontend
            appointment.setPrescription(prescription); 
            appointmentRepository.save(appointment); 
            return ResponseEntity.ok("Prescription updated successfully!");
        } else {
            return ResponseEntity.status(404).body("Appointment not found.");
        }
    }
}
