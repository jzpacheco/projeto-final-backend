package com.backend.projetofinal.controllers;


import com.backend.projetofinal.domain.appointment.Appointment;
import com.backend.projetofinal.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Appointment findById(
            @PathVariable(value = "id") UUID id
    ){

        return service.findById(id);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Appointment> findAll() {
        return service.findAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Appointment create(@RequestBody Appointment appointment){
        return service.create(appointment);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,  produces = MediaType.APPLICATION_JSON_VALUE)
    public Appointment update(@RequestBody Appointment appointment){
        return service.update(appointment);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(value = "/ajuda", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> ajuda() {
        Map<String, Object> response = new HashMap<>();
        response.put("estudantes", Arrays.asList("Alexandre Hermes", "Jeferson"));
        response.put("projeto", "Saúde e Bem-estar");
        response.put("tema", "Saúde e Bem-estar");

        return ResponseEntity.ok(response);
    }

}
