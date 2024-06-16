package br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoItem {
  private UUID id;

  private Produto produto;

  private Integer quantidade;

  private String observacao;

}
