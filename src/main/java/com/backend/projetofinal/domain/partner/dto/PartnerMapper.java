package com.backend.projetofinal.domain.partner.dto;

import com.backend.projetofinal.domain.partner.Partner;

public class PartnerMapper {

    public PartnerDTO toDto(Partner partner) {
        return new PartnerDTO(
                partner.getId(),
                partner.getName(),
                partner.getDocument(),
                partner.getBirthdate(),
                partner.getOccupation()
        );
    }

    public Partner toEntity(PartnerDTO partnerDTO) {
        return new Partner(
                partnerDTO.name(),
                partnerDTO.document(),
                partnerDTO.birthdate(),
                partnerDTO.occupation()
        );
    }
}
