package com.datapar.gestao_satisfacao.modules.usuario.entities;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    @Email(message = "O campo deve conter um e-mail válido!")
    private String email;

    @Length( max = 250, message = "A observação deve conter no máximo 250 caracteres.")
    private String observacoes;

}
