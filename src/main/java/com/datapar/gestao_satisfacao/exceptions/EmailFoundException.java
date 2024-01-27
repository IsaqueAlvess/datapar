package com.datapar.gestao_satisfacao.exceptions;

public class EmailFoundException extends RuntimeException{
    public EmailFoundException(){
        super("E-mail já utilizado.");
    }
}
