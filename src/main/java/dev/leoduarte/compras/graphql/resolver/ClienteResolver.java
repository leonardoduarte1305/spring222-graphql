package dev.leoduarte.compras.graphql.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.model.Compra;
import dev.leoduarte.compras.service.CompraService;

@Component
public class ClienteResolver implements GraphQLResolver<Cliente> {

	@Autowired
	private CompraService service;

	public List<Compra> compras(Cliente cliente) {
		return service.findAllByCliente(cliente);
	}
}
