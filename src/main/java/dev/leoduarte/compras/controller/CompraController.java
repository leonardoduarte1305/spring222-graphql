package dev.leoduarte.compras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.leoduarte.compras.model.Compra;
import dev.leoduarte.compras.model.input.CompraInput;
import dev.leoduarte.compras.service.CompraService;

@Component
public class CompraController implements GraphQLQueryResolver, GraphQLMutationResolver {

	private CompraService service;

	public Compra compra(Long id) {
		return service.findById(id);
	}

	public List<Compra> compras() {
		return service.findAll();
	}

	public Compra saveCompra(CompraInput input) {
		return service.save(input);
	}

	public boolean deleteCompra(Long id) {
		return service.deleteById(id);
	}

	@Autowired
	public CompraController(CompraService service) {
		this.service = service;
	}
}
