package com.backend.projetofinal.services;

import com.backend.projetofinal.domain.partner.Partner;
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

    public List<Partner> findAll(Integer pageParam, Integer results){
        Pageable page =  PageRequest.of(pageParam, results);
        Page<Partner> list = repository.findAll(page);
        return repository.findAll();
    }

    public Partner findById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Parceiro não encontrado"));
    }

    public Partner create(Partner partner){
        return repository.save(partner);
    }

    public Partner update(Partner partner){
        var entity = repository.findById(partner.getId()).orElseThrow(() -> new RuntimeException("Parceiro não encontrado"));

        entity.setName(partner.getName());
        entity.setDocument(partner.getDocument());
        entity.setBirthdate(partner.getBirthdate());
        entity.setOccupation(partner.getOccupation());

        return repository.save(entity);
    }

    public void delete(UUID id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Parceiro não encontrado"));
        repository.delete(entity);
    }
}
