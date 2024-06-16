package com.backend.projetofinal.controllers;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/ajuda")
public class HelpController {

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> ajuda() {
        Map<String, Object> response = new HashMap<>();
        response.put("estudantes", Arrays.asList("Alexandre Hermes", "Jefferson Pacheco"));
        response.put("projeto", "Gerenciador de consultas médicas");
        response.put("tema", "Saúde e Bem-estar");

        return ResponseEntity.ok(response);
    }

}
