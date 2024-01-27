package com.datapar.gestao_satisfacao.modules.avaliacao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datapar.gestao_satisfacao.modules.avaliacao.entities.AvaliacaoEntity;
import com.datapar.gestao_satisfacao.modules.avaliacao.services.CreateAvaliacao;

import jakarta.validation.Valid;

/**
 * AvaliacaoController
 */
@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private CreateAvaliacao createAvaliacao;
    

    @PostMapping("/")
    public ResponseEntity<Object> createAvaliacao(@Valid @RequestBody AvaliacaoEntity avaliacaoEntity){
        
        try {

            var result = this.createAvaliacao.execute(avaliacaoEntity);
            return ResponseEntity.ok().body(result);   

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }        
    } 

}
