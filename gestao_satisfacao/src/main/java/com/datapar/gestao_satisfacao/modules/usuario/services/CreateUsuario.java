package com.datapar.gestao_satisfacao.modules.usuario.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datapar.gestao_satisfacao.exceptions.EmailFoundException;
import com.datapar.gestao_satisfacao.modules.usuario.entities.UsuarioEntity;
import com.datapar.gestao_satisfacao.modules.usuario.repositories.UsuarioRepository;

@Service
public class CreateUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioEntity execute(UsuarioEntity usuarioEntity){

        this.usuarioRepository
            .findByEmail(usuarioEntity.getEmail())
            .ifPresent((user) -> {
                throw new EmailFoundException();
            });

        return this.usuarioRepository.save(usuarioEntity);
    } 

}
