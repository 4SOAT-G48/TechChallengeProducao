package br.com.fiap.soat.grupo48.grupo48.producao.application.service;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Pedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.SituacaoPedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.in.IProducaoPedidoPort;

import java.util.UUID;

public class ProducaoPedidoUseCaseImpl implements IProducaoPedidoPort {
    @Override
    public boolean entrarPedidoProducao(Pedido pedido) {
        return false;
    }

    @Override
    public Pedido atualizarSituacaoPedido(UUID id, SituacaoPedido situacaoPedido) {
        return null;
    }
}
