package br.com.fiap.soat.grupo48.grupo48.producao.application.service;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Pedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.SituacaoPedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.exception.ClienteIllegalArgumentException;
import br.com.fiap.soat.grupo48.grupo48.producao.application.exception.PedidoIllegalArgumentException;
import br.com.fiap.soat.grupo48.grupo48.producao.application.exception.PedidoNotFoundException;
import br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.in.IProducaoPedidoPort;
import br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.out.IProducaoPedidoRepositoryGateway;

import java.util.Objects;
import java.util.UUID;

public class ProducaoPedidoUseCaseImpl implements IProducaoPedidoPort {

    private final IProducaoPedidoRepositoryGateway producaoPedidoRepositoryGateway;

    public ProducaoPedidoUseCaseImpl(IProducaoPedidoRepositoryGateway producaoPedidoRepositoryGateway) {
        this.producaoPedidoRepositoryGateway = producaoPedidoRepositoryGateway;
    }

    @Override
    public Pedido entrarPedidoProducao(Pedido pedido) throws PedidoIllegalArgumentException, ClienteIllegalArgumentException {
        if (Objects.isNull(pedido)) {
            throw new PedidoIllegalArgumentException("Pedido não pode ser nulo");
        }
        if (Objects.isNull(pedido.getId())) {
            throw new PedidoIllegalArgumentException("Id do Pedido não informado.");
        }
        if (Objects.isNull(pedido.getItens()) || pedido.getItens().isEmpty()) {
            throw new PedidoIllegalArgumentException("Itens do Pedido não informados.");
        }
        if (Objects.isNull(pedido.getClienteId())) {
            throw new ClienteIllegalArgumentException("Cliente não informado.");
        }
        pedido.setSituacao(SituacaoPedido.FILA_PREPARACAO);
        producaoPedidoRepositoryGateway.salvar(pedido);
        return pedido;
    }

    @Override
    public Pedido atualizarSituacaoPedido(UUID id, SituacaoPedido situacaoPedido) throws PedidoNotFoundException, PedidoIllegalArgumentException {
        Pedido pedido = producaoPedidoRepositoryGateway.buscarPedidoPorId(id);
        if (Objects.isNull(pedido)) {
            throw new PedidoNotFoundException("Pedido não encontrado.");
        }
        if (situacaoPedido == SituacaoPedido.FILA_PREPARACAO && pedido.getSituacao() == SituacaoPedido.EM_PREPARACAO) {
            throw new PedidoIllegalArgumentException("Pedido não está na fila de preparação.");
        }
        if (situacaoPedido == SituacaoPedido.EM_PREPARACAO && pedido.getSituacao() == SituacaoPedido.PRONTO) {
            throw new PedidoIllegalArgumentException("Pedido não está em preparação.");
        }
        if (situacaoPedido == SituacaoPedido.PRONTO && pedido.getSituacao() == SituacaoPedido.EM_ENTREGA) {
            throw new PedidoIllegalArgumentException("Pedido não está pronto.");
        }
        if (situacaoPedido == SituacaoPedido.EM_ENTREGA && pedido.getSituacao() == SituacaoPedido.FINALIZADO) {
            throw new PedidoIllegalArgumentException("Pedido não está em entrega.");
        }

        pedido.setSituacao(situacaoPedido);
        producaoPedidoRepositoryGateway.salvar(pedido);
        return pedido;

    }
}
