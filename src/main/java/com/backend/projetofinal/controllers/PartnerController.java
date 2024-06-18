package com.backend.projetofinal.controllers;

import com.backend.projetofinal.domain.partner.Partner;
import com.backend.projetofinal.domain.partner.dto.PartnerDTO;
import com.backend.projetofinal.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    private PartnerService service;

    @GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PartnerDTO findById(@PathVariable(value = "id") UUID id){
        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PartnerDTO> findAll(@RequestParam(defaultValue = "0") Integer page,
                                    @RequestParam(defaultValue = "10") Integer results) {
        return service.findAll(page,results);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PartnerDTO create(@RequestBody PartnerDTO partner){
        return service.create(partner);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PartnerDTO update(@RequestBody PartnerDTO partner){
        return service.update(partner);
    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") UUID id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
