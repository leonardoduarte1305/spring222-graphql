package dev.leoduarte.compras.graphql;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.repository.ClienteRepository;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente cliente(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	public List<Cliente> clientes() {
		return clienteRepository.findAll();
	}

	@Transactional
	public Cliente saveCliente(Long id, String nome, String email) {
		return clienteRepository.save(new Cliente(id, nome, email));
	}

	public boolean deleteCliente(Long id) {
		clienteRepository.deleteById(id);
		return true;
	}

}
