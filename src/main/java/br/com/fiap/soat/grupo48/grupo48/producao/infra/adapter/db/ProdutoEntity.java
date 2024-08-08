package br.com.fiap.soat.grupo48.grupo48.producao.infra.adapter.db;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@Entity
@Table(name = "produtos")
public class ProdutoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String nome;
  private String descricao;

  /**
   * Construtor para criar um objeto do domínio
   *
   * @param produto objeto do domínio
   */
  public ProdutoEntity(Produto produto) {
    this.id = produto.getId();
    this.atualizar(produto);
  }

  /**
   * Converte este objeto em um objeto do domínio
   *
   * @return Produto
   */
  public Produto toProduto() {
    return new Produto(this.id, this.nome, this.descricao);
  }

  /**
   * Atualiza os dados do produto
   *
   * @param produto objeto do domínio
   */
  public void atualizar(Produto produto) {
    this.nome = produto.getNome();
    this.descricao = produto.getDescricao();
  }
}
