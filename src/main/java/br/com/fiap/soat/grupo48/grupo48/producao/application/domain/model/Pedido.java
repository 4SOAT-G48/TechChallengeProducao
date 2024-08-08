package br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model;

import br.com.fiap.soat.grupo48.grupo48.commons.model.JsonMapper;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Pedido extends JsonMapper {

  private UUID id;
  private UUID clienteId;
  private String clienteNome;
  private SituacaoPedido situacao;
  private String identificacao;
  private List<PedidoItem> itens;
  private Date dataCriacao;
  private Date dataAtualizacao;

}
