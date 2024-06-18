package com.backend.projetofinal.services;

import com.backend.projetofinal.domain.appointment.Appointment;
import com.backend.projetofinal.domain.appointment.dto.AppointmentDTO;
import com.backend.projetofinal.domain.appointment.mappers.AppointmentMapper;
import com.backend.projetofinal.exceptions.ResourceNotFoundException;
import com.backend.projetofinal.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    AppointmentMapper mapper;

    public List<AppointmentDTO> findAll(Integer page, Integer size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Appointment> entities = repository.findAll(pageable);
        return entities.map(mapper::toDto).toList();
    }

    public AppointmentDTO findById(UUID id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));
        return mapper.toDto(entity);
    }

    public AppointmentDTO create(AppointmentDTO appointment){
        var entity = mapper.toEntity(appointment);
        return mapper.toDto(repository.save(entity));
    }

    public AppointmentDTO update(AppointmentDTO appointment){
        var entity = repository.findById(appointment.id()).orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));
        var dtoEntity = mapper.toEntity(appointment);
        entity.setDescription(dtoEntity.getDescription());
        entity.setAppointmentDate(dtoEntity.getAppointmentDate());
        entity.setPatient(dtoEntity.getPatient());
        entity.setDoctor(dtoEntity.getDoctor());
        entity.setAttendant(dtoEntity.getAttendant());

        return mapper.toDto(repository.save(entity));
    }

    public void delete(UUID id){
        var entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));
        repository.delete(entity);
    }
}
