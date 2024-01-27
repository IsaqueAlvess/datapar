package com.datapar.gestao_satisfacao.exceptions;

public class EmailFoundException extends RuntimeException{
    public EmailFoundException(){
        super("Este e-mail já foi cadastrado. Tente cadastrar outro.");
    }
}
