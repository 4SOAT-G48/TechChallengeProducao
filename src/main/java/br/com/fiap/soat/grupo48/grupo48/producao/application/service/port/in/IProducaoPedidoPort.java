package br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.in;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Pedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.SituacaoPedido;

import java.util.UUID;

public interface IProducaoPedidoPort {
    boolean entrarPedidoProducao(Pedido pedido);

    Pedido atualizarSituacaoPedido(UUID id, SituacaoPedido situacaoPedido);

}
