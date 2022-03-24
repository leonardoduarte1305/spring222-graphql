package dev.leoduarte.compras.querys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.leoduarte.compras.model.Cliente;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

	public String hello() {
		return "Hello GraphQL";
	}

	public int soma(int a, int b) {
		return a + b;
	}

	public Cliente cliente() {
		return new Cliente("Cliente A", "clientea@clientes.com");
	}

	public List<Cliente> clientes() {
		List<Cliente> clientes = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			clientes.add(new Cliente("Cliente " + i, "cli" + i + "@email.com"));
		}

		return clientes;
	}
}
