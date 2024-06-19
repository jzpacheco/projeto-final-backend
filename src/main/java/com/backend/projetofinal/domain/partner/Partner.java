package com.backend.projetofinal.domain.partner;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Entity
public class Partner {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String document;
    private Date birthdate;
    private String occupation;

    public Partner() {
    }

    public Partner(String name, String document, Date birthdate, String occupation) {
        this.name = name;
        this.document = document;
        this.birthdate = birthdate;
        this.occupation = occupation;
    }

    public Partner(UUID id, String name, String document, Date birthdate, String occupation) {
        this.id = id;
        this.name = name;
        this.document = document;
        this.birthdate = birthdate;
        this.occupation = occupation;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
