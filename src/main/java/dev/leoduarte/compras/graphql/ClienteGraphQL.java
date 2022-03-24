package dev.leoduarte.compras.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.repository.ClienteRepository;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente cliente(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public List<Cliente> clientes() {
		return clienteRepository.findAll();
	}
}
