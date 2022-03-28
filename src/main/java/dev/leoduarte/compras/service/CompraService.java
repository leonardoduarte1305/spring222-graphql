package dev.leoduarte.compras.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.model.Compra;
import dev.leoduarte.compras.model.CompraResumo;
import dev.leoduarte.compras.model.input.CompraInput;
import dev.leoduarte.compras.repository.CompraRepository;

@Service
public class CompraService {

	private CompraRepository repository;
	private ProdutoService prodService;
	private ClienteService cliService;

	public Compra findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Compra> findAll(int page, int size) {
		return repository.findAll(PageRequest.of(page, size)).getContent();
	}

	@Transactional
	@CacheEvict(value = "comprasByCliente", key = "#input.cliente.id")
	public Compra save(CompraInput input) {
		ModelMapper m = new ModelMapper();
		Compra compra = m.map(input, Compra.class);

		compra.setData(new Date());

		compra.setCliente(cliService.findById(input.getClienteId()));
		compra.setProduto(prodService.findById(input.getProdutoId()));

		return repository.save(compra);
	}

	@CacheEvict(value = "comprasByCliente", key = "#id")
	@Transactional
	public boolean deleteById(Long id) {
		if (repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

	@Cacheable(value = "comprasByCliente", key = "#cliente.id")
	public List<Compra> findAllByCliente(Cliente cliente) {
		return repository.findAllByCliente(cliente);
	}

	public List<CompraResumo> findAllComprasRelatorio() {
		return repository.findAllComprasRelatorio();
	}

	@Autowired
	public CompraService(CompraRepository repository, ProdutoService prodService, ClienteService cliService) {
		this.repository = repository;
		this.cliService = cliService;
		this.prodService = prodService;
	}
}
