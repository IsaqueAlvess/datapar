package com.datapar.gestao_satisfacao.modules.avaliacao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datapar.gestao_satisfacao.exceptions.EmailFoundException;
import com.datapar.gestao_satisfacao.modules.avaliacao.entities.AvaliacaoEntity;
import com.datapar.gestao_satisfacao.modules.avaliacao.repositories.AvaliacaoRepository;

@Service
public class CreateAvaliacao {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoEntity execute(AvaliacaoEntity avaliacaoEntity){
        this.avaliacaoRepository
            .findByEmail(avaliacaoEntity.getEmail())
            .ifPresent((user) -> {
                throw new EmailFoundException();
            });

        return this.avaliacaoRepository.save(avaliacaoEntity);
    }
}
