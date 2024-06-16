package com.backend.projetofinal.services;

import com.backend.projetofinal.domain.pacient.Patient;
import com.backend.projetofinal.repositories.PacientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PacientService {

    @Autowired
    private PacientRepository repository;

    public Page<Patient> findAll(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        return repository.findAll(pageable);
    }

    public Patient findById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
    }

    public Patient create(Patient patient){
        return repository.save(patient);
    }

    public Patient update(Patient patient){
        var entity = repository.findById(patient.getId()).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        entity.setName(patient.getName());
        entity.setDocument(patient.getDocument());
        entity.setBirthdate(patient.getBirthdate());
        entity.setPrognostic(patient.getPrognostic());

        return repository.save(entity);
    }

    public void delete(UUID id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        repository.delete(entity);
    }
}
