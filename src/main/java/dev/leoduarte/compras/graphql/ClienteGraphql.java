package dev.leoduarte.compras.graphql;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.model.input.ClienteInput;
import dev.leoduarte.compras.service.ClienteService;

@Component
public class ClienteGraphql implements GraphQLQueryResolver, GraphQLMutationResolver {

	private ClienteService service;

	public Cliente cliente(Long id) {
		return service.findById(id);
	}

	public List<Cliente> clientes() {
		return service.findAll();
	}

	public Cliente saveCliente(ClienteInput input) {
		ModelMapper m = new ModelMapper();
		Cliente cli = m.map(input, Cliente.class);

		return service.save(cli);
	}

	public boolean deleteCliente(Long id) {
		return service.deleteById(id);
	}

	@Autowired
	public ClienteGraphql(ClienteService service) {
		this.service = service;
	}
}
