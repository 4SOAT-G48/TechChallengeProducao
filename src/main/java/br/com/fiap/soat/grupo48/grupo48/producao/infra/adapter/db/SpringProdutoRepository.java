package br.com.fiap.soat.grupo48.grupo48.producao.infra.adapter.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpringProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {

  @Query(value = "SELECT p FROM ProdutoEntity p ORDER BY p.id")
  Page<ProdutoEntity> findProdutos(Pageable pageable);
}
