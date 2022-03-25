package dev.leoduarte.compras.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.model.Compra;
import dev.leoduarte.compras.model.CompraResumo;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

	List<Compra> findAllByCliente(Cliente cliente);

	@Query("select new dev.leoduarte.compras.model.CompraResumo(c.id, cli.nome, p.nome, c.quantidade) from Compra c inner join c.cliente cli inner join c.produto p ")
	List<CompraResumo> findAllComprasRelatorio();

}
