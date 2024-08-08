package br.com.fiap.soat.grupo48.grupo48.producao.infra.adapter.db;

import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.Pedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.domain.model.SituacaoPedido;
import br.com.fiap.soat.grupo48.grupo48.producao.application.service.port.out.IProducaoPedidoRepositoryGateway;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Component
public class ProducaoPedidoRepositoryGateway implements IProducaoPedidoRepositoryGateway {

    private final SpringPedidoRepository springPedidoRepository;

    public ProducaoPedidoRepositoryGateway(SpringPedidoRepository springPedidoRepository) {
        this.springPedidoRepository = springPedidoRepository;
    }

    @Override
    public Pedido salvar(Pedido pedido) {
        PedidoEntity pedidoEntity = null;
        if (Objects.nonNull(pedido.getId())) {
            Optional<PedidoEntity> byId = this.springPedidoRepository.findById(pedido.getId());
            if (byId.isPresent()) {
                pedidoEntity = byId.get();
                pedidoEntity.atualizar(pedido);
            }
        }

        if (Objects.isNull(pedidoEntity)) {
            pedidoEntity = new PedidoEntity(pedido);
        }
        return this.springPedidoRepository.save(pedidoEntity).toPedido();
    }

    @Override
    public Pedido atualizarSituacao(UUID id, SituacaoPedido situacao) {
        Optional<PedidoEntity> byId = this.springPedidoRepository.findById(id);
        if (byId.isPresent()) {
            PedidoEntity pedidoEntity = byId.get();
            pedidoEntity.setSituacao(situacao);
            return this.springPedidoRepository.save(pedidoEntity).toPedido();
        } else {
            return null;
        }
    }

    @Override
    public List<Pedido> buscaPedidosPorSituacoes(List<SituacaoPedido> situacoes) {
        List<PedidoEntity> bySituacaoIn = this.springPedidoRepository.findBySituacaoIn(situacoes);
        return bySituacaoIn.stream().map(PedidoEntity::toPedido).toList();
    }

    @Override
    public Pedido buscarPedidoPorId(UUID id) {
        Optional<PedidoEntity> byId = this.springPedidoRepository.findById(id);
        return byId.map(PedidoEntity::toPedido).orElse(null);
    }


}
