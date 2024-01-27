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

    @NotBlank( message = "Campo Nome obrigatório")
    private String name;

    @NotBlank( message = "Campo Email obrigatório")
    @Email(message = "O campo deve conter um e-mail válido!")
    private String email;

    @NotBlank( message = "Campo obrigatório")
    @Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres.")
    private String password;
    

}
