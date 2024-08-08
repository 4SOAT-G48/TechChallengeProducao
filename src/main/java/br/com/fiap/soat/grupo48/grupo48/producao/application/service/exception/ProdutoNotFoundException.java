package br.com.fiap.soat.grupo48.grupo48.producao.application.service.exception;

import br.com.fiap.soat.grupo48.grupo48.commons.exception.ApplicationException;

public class ProdutoNotFoundException extends ApplicationException {
  public ProdutoNotFoundException(String mensagem) {
    super(mensagem);
  }
}
