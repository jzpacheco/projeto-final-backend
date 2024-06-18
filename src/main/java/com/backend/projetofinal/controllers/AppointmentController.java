package com.backend.projetofinal.controllers;

import com.backend.projetofinal.domain.appointment.Appointment;
import com.backend.projetofinal.domain.appointment.dto.AppointmentDTO;
import com.backend.projetofinal.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppointmentDTO> findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return service.findAll(page, size);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AppointmentDTO findById(@PathVariable(value = "id") UUID id){
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppointmentDTO create(@RequestBody AppointmentDTO appointment){
        return service.create(appointment);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public AppointmentDTO update(@RequestBody AppointmentDTO appointment){
        return service.update(appointment);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
