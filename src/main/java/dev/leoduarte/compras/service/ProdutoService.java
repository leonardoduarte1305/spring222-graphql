package dev.leoduarte.compras.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.leoduarte.compras.model.Produto;
import dev.leoduarte.compras.model.input.ProdutoInput;
import dev.leoduarte.compras.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository repository;

	public Produto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}

	@Transactional
	public Produto save(ProdutoInput input) {
		ModelMapper m = new ModelMapper();
		Produto produto = m.map(input, Produto.class);
		return repository.save(produto);
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
	public ProdutoService(ProdutoRepository repository) {
		this.repository = repository;
	}

}
