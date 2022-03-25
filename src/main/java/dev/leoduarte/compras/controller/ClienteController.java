package dev.leoduarte.compras.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.model.input.ClienteInput;
import dev.leoduarte.compras.service.ClienteService;

@Component
public class ClienteController implements GraphQLQueryResolver, GraphQLMutationResolver {

	private ClienteService service;

	public Cliente cliente(Long id) {
		return service.findById(id);
	}

	public List<Cliente> clientes() {
		return service.findAll();
	}

	public Cliente saveCliente(ClienteInput input) {
		return service.save(input);
	}

	public boolean deleteCliente(Long id) {
		return service.deleteById(id);
	}

	@Autowired
	public ClienteController(ClienteService service) {
		this.service = service;
	}
}
