package com.backend.projetofinal.domain.patient.dto;

import com.backend.projetofinal.domain.patient.Patient;

public class PatientMapper {

    public PatientDTO toDto(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getDocument(),
                patient.getBirthdate(),
                patient.getPrognostic()
        );
    }

    public Patient toEntity(PatientDTO patientDTO) {
        return new Patient(
                patientDTO.name(),
                patientDTO.document(),
                patientDTO.birthdate(),
                patientDTO.prognostic()
        );
    }
}
