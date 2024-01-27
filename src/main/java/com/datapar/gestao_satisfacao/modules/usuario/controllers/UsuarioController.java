package com.datapar.gestao_satisfacao.modules.usuario.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datapar.gestao_satisfacao.modules.usuario.entities.UsuarioEntity;
import com.datapar.gestao_satisfacao.modules.usuario.services.CreateUsuario;

import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

/**
 * UsuarioController
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private CreateUsuario createUsuario;

    @PostMapping("/")
    public ResponseEntity<Object> createUsuario(@Valid @RequestBody UsuarioEntity usuarioEntity){
        
        try {
        
            var result = this.createUsuario.execute(usuarioEntity);
            return ResponseEntity.ok().body(result);   

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }        
    }
}