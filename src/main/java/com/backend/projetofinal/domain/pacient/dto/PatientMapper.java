package com.backend.projetofinal.domain.pacient.dto;

import com.backend.projetofinal.domain.pacient.Patient;
import com.backend.projetofinal.domain.pacient.PatientDTO;

public class PatientMapper {

    public static PatientDTO toDto(Patient patient) {
        return new PatientDTO(
                patient.getId(),
                patient.getName(),
                patient.getDocument(),
                patient.getBirthdate(),
                patient.getPrognostic()
        );
    }

    public static Patient toEntity(PatientDTO patientDTO) {
        return new Patient(
                patientDTO.name(),
                patientDTO.document(),
                patientDTO.birthdate(),
                patientDTO.prognostic()
        );
    }
}
