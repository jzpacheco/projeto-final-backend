package com.backend.projetofinal.domain.appointment;

import java.util.Date;
import java.util.UUID;

public class AppointmentDTO {
    private UUID id;
    private String description;
    private Date appointmentDate;
    private UUID patientId;
    private UUID doctorId;
    private UUID attendantId;

    // Getters and Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
    }

    public UUID getAttendantId() {
        return attendantId;
    }

    public void setAttendantId(UUID attendantId) {
        this.attendantId = attendantId;
    }
}
