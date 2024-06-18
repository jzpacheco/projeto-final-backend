package com.backend.projetofinal.domain.pacient;

import java.util.Date;
import java.util.UUID;

public record PatientDTO(UUID id,
                         String name,
                         String document,
                         Date birthdate,
                         String prognostic) {
}
