package dev.leoduarte.compras.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.leoduarte.compras.model.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
