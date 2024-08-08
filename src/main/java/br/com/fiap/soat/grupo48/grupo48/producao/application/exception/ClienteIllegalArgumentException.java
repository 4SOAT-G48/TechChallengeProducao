package br.com.fiap.soat.grupo48.grupo48.producao.application.exception;

import br.com.fiap.soat.grupo48.grupo48.commons.exception.ApplicationException;

public class ClienteIllegalArgumentException extends ApplicationException {
    public ClienteIllegalArgumentException(String menssage) {
        super(menssage);
    }
}
