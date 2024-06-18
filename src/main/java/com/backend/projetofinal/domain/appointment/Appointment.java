package com.backend.projetofinal.domain.appointment;

import com.backend.projetofinal.domain.patient.Patient;
import com.backend.projetofinal.domain.partner.Partner;
import jakarta.persistence.*;

import java.util.Date;
import java.util.UUID;

@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private Date appointmentDate;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Partner doctor;

    @ManyToOne
    @JoinColumn(name = "attendant_id")
    private Partner attendant;

    public Appointment() {
    }

    public Appointment(String description, Date appointmentDate, Patient patient, Partner doctor, Partner attendant) {
        this.description = description;
        this.appointmentDate = appointmentDate;
        this.patient = patient;
        this.doctor = doctor;
        this.attendant = attendant;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient pacient) {
        this.patient = pacient;
    }

    public Partner getDoctor() {
        return doctor;
    }

    public void setDoctor(Partner doctor) {
        this.doctor = doctor;
    }

    public Partner getAttendant() {
        return attendant;
    }

    public void setAttendant(Partner attendant) {
        this.attendant = attendant;
    }
}
