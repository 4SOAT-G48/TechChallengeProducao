package br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder(toBuilder = true)
@AllArgsConstructor
public class Produto {
  @Setter
  private UUID id;
  @Setter
  private String nome;
  @Setter
  private String descricao;

  //TODO: adicionar as datas de cadastro e atualização

  public void atualiza(Produto produto) {
    this.nome = produto.getNome();
    this.descricao = produto.getDescricao();
  }
}
