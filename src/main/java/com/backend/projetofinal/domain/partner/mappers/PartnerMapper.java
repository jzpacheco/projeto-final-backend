package com.backend.projetofinal.domain.partner.mappers;

import com.backend.projetofinal.domain.partner.Partner;
import com.backend.projetofinal.domain.partner.dto.PartnerDTO;
import org.springframework.stereotype.Component;

@Component
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
                partnerDTO.id(),
                partnerDTO.name(),
                partnerDTO.document(),
                partnerDTO.birthdate(),
                partnerDTO.occupation()
        );
    }
}
