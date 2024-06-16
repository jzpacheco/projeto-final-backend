package com.backend.projetofinal.controllers;

import com.backend.projetofinal.domain.pacient.Patient;
import com.backend.projetofinal.services.PacientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/patient")
public class PacientController {

    @Autowired
    private PacientService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Patient> findAll(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        return service.findAll(page, size);
    }

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient findById(@PathVariable(value = "id") UUID id){
        return service.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient create(@RequestBody Patient patient){
        return service.create(patient);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Patient update(@RequestBody Patient patient){
        return service.update(patient);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
