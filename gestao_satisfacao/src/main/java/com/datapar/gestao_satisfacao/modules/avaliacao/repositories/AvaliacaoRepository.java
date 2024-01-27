package com.datapar.gestao_satisfacao.modules.avaliacao.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.datapar.gestao_satisfacao.modules.avaliacao.entities.AvaliacaoEntity;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, UUID>{

    Optional <AvaliacaoEntity> findByEmail(String email);
}
