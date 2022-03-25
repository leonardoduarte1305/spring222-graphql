package dev.leoduarte.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.leoduarte.compras.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
