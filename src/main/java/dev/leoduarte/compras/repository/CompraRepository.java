package dev.leoduarte.compras.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import dev.leoduarte.compras.model.Compra;
import dev.leoduarte.compras.model.CompraResumo;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	@Query("select c from Compra c where c.cliente.id = :clienteId")
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
	List<Compra> findAllByCliente(@Param("clienteId") Long clienteId);

	@Query("select new dev.leoduarte.compras.model.CompraResumo(c.id, cli.nome, p.nome, c.quantidade) from Compra c inner join c.cliente cli inner join c.produto p ")
	List<CompraResumo> findAllComprasRelatorio();

}
