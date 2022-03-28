package dev.leoduarte.compras.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Repository;

import dev.leoduarte.compras.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	@Override
	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value = "true") })
	List<Cliente> findAll();
}
