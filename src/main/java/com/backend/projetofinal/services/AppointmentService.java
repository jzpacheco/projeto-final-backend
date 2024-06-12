package com.backend.projetofinal.services;

import com.backend.projetofinal.domain.appointment.Appointment;
import com.backend.projetofinal.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public List<Appointment> findAll(){
        return repository.findAll();
    }
    public Appointment findById(UUID id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
    }
    public Appointment create(Appointment appointment){
        return repository.save(appointment);
    }
    public Appointment update(Appointment appointment){
        var entity = repository.findById(appointment.getId()).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        entity.setDescription(appointment.getDescription());
        entity.setAppointmentDate(appointment.getAppointmentDate());
        entity.setPatient(appointment.getPatient());
        entity.setDoctor(appointment.getDoctor());
        entity.setAttendant(appointment.getAttendant());

        return repository.save(entity);
    }
    public void delete(UUID id){
        var entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        repository.delete(entity);
    }

}
