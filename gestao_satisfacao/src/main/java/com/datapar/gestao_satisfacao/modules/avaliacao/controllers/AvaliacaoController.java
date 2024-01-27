package com.datapar.gestao_satisfacao.modules.avaliacao.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datapar.gestao_satisfacao.modules.avaliacao.entities.AvaliacaoEntity;
import com.datapar.gestao_satisfacao.modules.avaliacao.repositories.AvaliacaoRepository;
import com.datapar.gestao_satisfacao.modules.avaliacao.services.CreateAvaliacao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

/**
 * AvaliacaoController
 */
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private CreateAvaliacao createAvaliacao;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @PostMapping("/")
    public ResponseEntity<Object> createAvaliacao(@Valid @RequestBody AvaliacaoEntity avaliacaoEntity){
        
        try {

            var result = this.createAvaliacao.execute(avaliacaoEntity);
            return ResponseEntity.ok().body(result);   

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }        
    } 

    @GetMapping("/avaliacoes")
    public ResponseEntity<String> listarAvaliacoes() throws JsonProcessingException{
        
        List<AvaliacaoEntity> avaliacoes = avaliacaoRepository.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(avaliacoes);

        return ResponseEntity.ok(json);

    }


}
