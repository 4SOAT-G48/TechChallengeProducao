package br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.in;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Pedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.SituacaoPedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.exception.ClienteIllegalArgumentException;
import br.com.fiap.soat.grupo48.grupo48.producao.application.exception.PedidoIllegalArgumentException;
import br.com.fiap.soat.grupo48.grupo48.producao.application.exception.PedidoNotFoundException;

import java.util.UUID;

public interface IProducaoPedidoPort {
    /**
     * Faz a entrada do pedido para produção.
     *
     * @param pedido pedido com os dados a serem salvos
     * @return pedido com os dados conforme salvos
     */
    Pedido entrarPedidoProducao(Pedido pedido) throws PedidoIllegalArgumentException, ClienteIllegalArgumentException;

    Pedido atualizarSituacaoPedido(UUID id, SituacaoPedido situacaoPedido) throws PedidoNotFoundException, PedidoIllegalArgumentException;

}
