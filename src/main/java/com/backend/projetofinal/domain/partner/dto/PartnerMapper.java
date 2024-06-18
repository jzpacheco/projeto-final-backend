package com.backend.projetofinal.domain.partner.dto;

import com.backend.projetofinal.domain.partner.Partner;
import com.backend.projetofinal.domain.partner.PartnerDTO;

public class PartnerMapper {

    public static PartnerDTO toDto(Partner partner) {
        return new PartnerDTO(
                partner.getId(),
                partner.getName(),
                partner.getDocument(),
                partner.getBirthdate(),
                partner.getOccupation()
        );
    }

    public static Partner toEntity(PartnerDTO partnerDTO) {
        return new Partner(
                partnerDTO.name(),
                partnerDTO.document(),
                partnerDTO.birthdate(),
                partnerDTO.occupation()
        );
    }
}
