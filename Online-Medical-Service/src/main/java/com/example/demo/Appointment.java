package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String patientName;
    private String appointmentDate;
    private String reason;
    
    private String Status ;
    @Column(length = 1000) // Ensure sufficient length
    private String prescription;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patientName=" + patientName + ", appointmentDate=" + appointmentDate
				+ ", reason=" + reason + ", Status=" + Status + ", prescription=" + prescription + ", getId()="
				+ getId() + ", getPatientName()=" + getPatientName() + ", getAppointmentDate()=" + getAppointmentDate()
				+ ", getReason()=" + getReason() + ", getStatus()=" + getStatus() + ", getPrescription()="
				+ getPrescription() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

	


   
}
