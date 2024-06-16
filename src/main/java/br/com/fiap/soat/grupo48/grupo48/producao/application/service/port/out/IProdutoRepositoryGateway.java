package br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.out;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Produto;
import br.com.fiap.soat.grupo48.grupo48.producao.application.service.exception.ProdutoNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface IProdutoRepositoryGateway {
  List<Produto> buscarTodos();

  Page<Produto> buscarTodos(Pageable pageable);

  Produto buscarPeloId(UUID id) throws ProdutoNotFoundException;

  Produto salvar(Produto produto) throws ProdutoNotFoundException;

  boolean excluir(UUID id) throws ProdutoNotFoundException;
}
