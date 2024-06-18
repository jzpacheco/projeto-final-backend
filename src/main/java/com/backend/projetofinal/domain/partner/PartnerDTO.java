package com.backend.projetofinal.domain.partner;

import java.util.Date;
import java.util.UUID;

public record PartnerDTO(UUID id,
                         String name,
                         String document,
                         Date birthdate,
                         String occupation) {
}