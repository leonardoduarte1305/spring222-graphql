package dev.leoduarte.compras.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.repository.ClienteRepository;

@Service
public class ClienteService {

	private ClienteRepository repository;

	public Cliente findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Cliente save(Cliente c) {
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

	@Autowired
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
}
