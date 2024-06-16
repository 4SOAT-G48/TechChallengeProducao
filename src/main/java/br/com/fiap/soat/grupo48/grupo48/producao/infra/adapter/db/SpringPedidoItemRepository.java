package br.com.fiap.soat.grupo48.grupo48.producao.infra.adapter.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringPedidoItemRepository extends JpaRepository<PedidoItemEntity, UUID> {
}
