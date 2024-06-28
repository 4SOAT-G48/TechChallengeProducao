package br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.out;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Pedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.SituacaoPedido;

import java.util.List;
import java.util.UUID;

public interface IPedidoSituacaoPort {
    boolean atualizarSituacao(UUID pedidoId, SituacaoPedido situacaoPedido);

    List<Pedido> buscarPedidosPorSituacao(List<SituacaoPedido> situacoes);

    List<Pedido> buscarPedidosMostradosMonitorCliente();
}
