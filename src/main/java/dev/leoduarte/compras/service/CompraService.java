package dev.leoduarte.compras.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.leoduarte.compras.exception.DomainException;
import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.model.Compra;
import dev.leoduarte.compras.model.CompraResumo;
import dev.leoduarte.compras.repository.CompraRepository;

@Service
public class CompraService {

	private CompraRepository repository;

	public Compra findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Compra> findAll(Pageable p) {
		return repository.findAll(p).getContent();
	}

	@Transactional
	public Compra save(Compra c) {
		if (c.getQuantidade() > 100) {
			throw new DomainException("Não é possível fazer uma compra com mais de 100 itens.");
		}

		return repository.save(c);
	}

	@Transactional
	public boolean deleteById(Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Compra> findAllByCliente(Cliente cliente) {
		return repository.findAllByCliente(cliente.getId());
	}

	public List<CompraResumo> findAllComprasRelatorio() {
		return repository.findAllComprasRelatorio();
	}

	@Autowired
	public CompraService(CompraRepository repository) {
		this.repository = repository;
	}
}
