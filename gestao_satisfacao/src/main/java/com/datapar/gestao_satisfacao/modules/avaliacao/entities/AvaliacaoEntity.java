package com.datapar.gestao_satisfacao.modules.avaliacao.entities;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity( name = "avaliacoes")
public class AvaliacaoEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private Integer pontuacao;

    @NotBlank
    @Email(message = "O campo deve conter um e-mail válido!")
    private String email;

    private String contato;

    @Length( max = 250, message = "A observação deve conter no máximo 250 caracteres.")
    private String observacoes;

}
