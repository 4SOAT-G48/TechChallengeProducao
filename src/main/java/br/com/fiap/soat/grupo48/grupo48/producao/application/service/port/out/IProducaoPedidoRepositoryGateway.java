package br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.out;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Pedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.SituacaoPedido;

import java.util.List;
import java.util.UUID;

public interface IProducaoPedidoRepositoryGateway {
    Pedido salvar(Pedido pedido);

    Pedido atualizarSituacao(UUID id, SituacaoPedido situacao);

    List<Pedido> buscaPedidosPorSituacoes(List<SituacaoPedido> situacoes);

}
