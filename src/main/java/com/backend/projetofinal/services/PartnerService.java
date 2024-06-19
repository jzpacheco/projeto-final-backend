package com.backend.projetofinal.services;

import com.backend.projetofinal.domain.partner.Partner;
import com.backend.projetofinal.domain.partner.dto.PartnerDTO;
import com.backend.projetofinal.domain.partner.mappers.PartnerMapper;
import com.backend.projetofinal.exceptions.ResourceNotFoundException;
import com.backend.projetofinal.repositories.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PartnerService {

    @Autowired
    private PartnerRepository repository;

    @Autowired
    private PartnerMapper mapper;

    public List<PartnerDTO> findAll(Integer pageParam, Integer results){
        Pageable page =  PageRequest.of(pageParam, results);
        Page<Partner> list = repository.findAll(page);
        return list.map(mapper::toDto).toList();
    }

    public PartnerDTO findById(UUID id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Parceiro não encontrado"));
        return mapper.toDto(entity);
    }

    public PartnerDTO create(PartnerDTO partner){
        var entity = mapper.toEntity(partner);
        return mapper.toDto(repository.save(entity));
    }

    public PartnerDTO update(PartnerDTO partner){
        var entity = repository.findById(partner.id()).orElseThrow(() -> new ResourceNotFoundException("Parceiro não encontrado"));

        entity.setName(partner.name());
        entity.setDocument(partner.document());
        entity.setBirthdate(partner.birthdate());
        entity.setOccupation(partner.occupation());

        return mapper.toDto(repository.save(entity));
    }

    public void delete(UUID id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Parceiro não encontrado"));
        repository.delete(entity);
    }
}
