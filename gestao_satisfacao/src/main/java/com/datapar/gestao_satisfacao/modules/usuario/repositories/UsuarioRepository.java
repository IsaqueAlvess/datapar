package com.datapar.gestao_satisfacao.modules.usuario.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datapar.gestao_satisfacao.modules.usuario.entities.UsuarioEntity;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, UUID>{
    
    Optional <UsuarioEntity> findByEmail(String email);
    
}
