package com.backend.projetofinal.domain.pacient;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.UUID;

@Entity
public class Pacient {

    @Id()
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private String document;
    private Date birthdate;
    private String prognostic;

    public Pacient() {
    }

    public Pacient(String name, String document, Date birthdate, String prognostic) {
        this.name = name;
        this.document = document;
        this.birthdate = birthdate;
        this.prognostic = prognostic;
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

    public String getPrognostic() {
        return prognostic;
    }

    public void setPrognostic(String prognostic) {
        this.prognostic = prognostic;
    }
}
