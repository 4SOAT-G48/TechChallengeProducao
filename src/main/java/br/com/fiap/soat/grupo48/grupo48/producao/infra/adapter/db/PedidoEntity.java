package br.com.fiap.soat.grupo48.grupo48.producao.infra.adapter.db;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Pedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.SituacaoPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.*;

@Getter
@Entity
@Table(name = "pedidos")
public class PedidoEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column(name = "cliente_id", nullable = true)
  private UUID clienteId;

  @Column(name = "cliente_nome", nullable = true)
  private String clienteNome;

  @Setter
  @Enumerated(EnumType.STRING)
  private SituacaoPedido situacao;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<PedidoItemEntity> itens = new ArrayList<>();

  private String identificacao;

  @Column(name = "data_criacao", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataCriacao;

  @Column(name = "data_atualizacao", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
  @Temporal(TemporalType.TIMESTAMP)
  private Date dataAtualizacao;


  public PedidoEntity() {
  }

  public PedidoEntity(Pedido pedido) {
    this.atualizar(pedido);
  }

  public void atualizar(Pedido pedido) {
    if (Objects.nonNull(pedido.getClienteId())) {
      this.clienteId = pedido.getClienteId();
      this.clienteNome = pedido.getClienteNome();
    }

    if (Objects.nonNull(pedido.getItens())) {
      this.itens = pedido.getItens().stream().map(pedidoItem -> {
        PedidoItemEntity pedidoItemEntity = new PedidoItemEntity(pedidoItem);
        pedidoItemEntity.setPedido(this);
        return pedidoItemEntity;
      }).toList();
    }
    this.identificacao = pedido.getIdentificacao();
  }

  @PrePersist
  public void insereDatas() {
    if (Objects.isNull(this.dataCriacao)) {
      this.dataCriacao = new Timestamp(Calendar.getInstance().getTimeInMillis());
      this.dataAtualizacao = new Timestamp(Calendar.getInstance().getTimeInMillis());
    }
  }

  @PreUpdate
  public void atualizaDataAtualizacao() {
    this.dataAtualizacao = new Timestamp(Calendar.getInstance().getTimeInMillis());
  }

  public Pedido toPedido() {
    return new Pedido(
        this.getId(),
        this.getClienteId(),
        this.getClienteNome(),
        this.getSituacao(),
        this.getIdentificacao(),
        this.getItens().stream().map(PedidoItemEntity::toPedidoItem).toList(),
        this.getDataCriacao(),
        this.getDataAtualizacao()
        );

  }


}
