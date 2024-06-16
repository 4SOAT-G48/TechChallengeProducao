package br.com.fiap.soat.grupo48.grupo48.producao.infra.adapter.db;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Produto;
import br.com.fiap.soat.grupo48.grupo48.producao.application.service.exception.ProdutoNotFoundException;
import br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.out.IProdutoRepositoryGateway;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * Implementação de classe para manutenção do produto.
 *
 * @author andrelaus
 */
@Component
public class ProdutoRepositoryGateway implements IProdutoRepositoryGateway {

  private final SpringProdutoRepository springProdutoRepository;

  public ProdutoRepositoryGateway(SpringProdutoRepository springProdutoRepository) {
    this.springProdutoRepository = springProdutoRepository;
  }

  @Override
  public List<Produto> buscarTodos() {
    List<ProdutoEntity> produtoEntity = this.springProdutoRepository.findAll();
    return produtoEntity.stream().map(ProdutoEntity::toProduto).toList();
  }

  @Override
  public Page<Produto> buscarTodos(Pageable pageable) {
    Page<ProdutoEntity> produtoEntity = this.springProdutoRepository.findAll(pageable);
    return produtoEntity.map(ProdutoEntity::toProduto);
  }

  @Override
  public Produto buscarPeloId(UUID id) throws ProdutoNotFoundException {
    Optional<ProdutoEntity> produtoEntityOptional = this.springProdutoRepository.findById(id);
    if (produtoEntityOptional.isEmpty()) {
      throw new ProdutoNotFoundException("Produto não encontrado com o ID: " + id);
    }
    ProdutoEntity produtoEntity = produtoEntityOptional.get();
    return produtoEntity.toProduto();
  }

  @Override
  public Produto salvar(Produto produto) throws ProdutoNotFoundException {
    ProdutoEntity produtoEntity;
    if (Objects.isNull(produto.getId())) {
      produtoEntity = new ProdutoEntity(produto);
    } else {
      var produtoEncontrado = this.springProdutoRepository.findById(produto.getId());
      if (produtoEncontrado.isEmpty()) {
        throw new ProdutoNotFoundException("Produto não encontrado com o ID: " + produto.getId());
      }
      produtoEntity = produtoEncontrado.get();
      produtoEntity.atualizar(produto);
    }

    return this.springProdutoRepository.save(produtoEntity).toProduto();
  }

  @Override
  public boolean excluir(UUID id) throws ProdutoNotFoundException {
    Optional<ProdutoEntity> produtoEntityOptional = this.springProdutoRepository.findById(id);
    if (produtoEntityOptional.isEmpty()) {
      throw new ProdutoNotFoundException("Não foi possível excluir o produto");
    }
    this.springProdutoRepository.deleteById(id);
    return true;
  }
}
