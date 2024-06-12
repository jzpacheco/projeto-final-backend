package com.backend.projetofinal.domain.appointment;

import com.backend.projetofinal.domain.pacient.Pacient;
import com.backend.projetofinal.domain.partner.Partner;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Entity
public class Appointment {

    @Id
    @GeneratedValue
    private UUID id;
    private String description;
    private Date appointmentDate;
    private Pacient pacient;
    private Partner doctor;
    private Partner attendant;

    public Appointment() {
    }

    public Appointment(String description, Date appointmentDate, Pacient pacient, Partner doctor, Partner attendant) {
        this.description = description;
        this.appointmentDate = appointmentDate;
        this.pacient = pacient;
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

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
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
