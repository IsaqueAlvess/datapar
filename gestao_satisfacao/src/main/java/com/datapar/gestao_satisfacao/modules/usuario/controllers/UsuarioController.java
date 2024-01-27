package com.datapar.gestao_satisfacao.modules.usuario.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.datapar.gestao_satisfacao.modules.usuario.entities.UsuarioEntity;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

/**
 * UsuarioController
 */
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    @PostMapping("/")
    public void create(@Valid @RequestBody UsuarioEntity usuarioEntity){
        System.out.println("Usuario");
        System.out.println(usuarioEntity);
        
    }

}