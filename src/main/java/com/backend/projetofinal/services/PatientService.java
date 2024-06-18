package com.backend.projetofinal.services;

import com.backend.projetofinal.domain.patient.Patient;
import com.backend.projetofinal.domain.patient.dto.PatientDTO;
import com.backend.projetofinal.domain.patient.dto.PatientMapper;
import com.backend.projetofinal.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    @Autowired
    private PatientMapper mapper;

    public List<PatientDTO> findAll(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Patient> entities = repository.findAll(pageable);
        return entities.map(mapper::toDto).toList();
    }

    public PatientDTO findById(UUID id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        return mapper.toDto(entity);
    }

    public PatientDTO create(PatientDTO patient){
        var entity = mapper.toEntity(patient);
        return mapper.toDto(repository.save(entity));
    }

    public PatientDTO update(PatientDTO patient){
        var entity = repository.findById(patient.id()).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        entity.setName(patient.name());
        entity.setDocument(patient.document());
        entity.setBirthdate(patient.birthdate());
        entity.setPrognostic(patient.prognostic());

        return mapper.toDto(repository.save(entity));
    }

    public void delete(UUID id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        repository.delete(entity);
    }
}
