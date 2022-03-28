package dev.leoduarte.compras.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import dev.leoduarte.compras.model.Cliente;
import dev.leoduarte.compras.model.Compra;
import dev.leoduarte.compras.model.Produto;
import dev.leoduarte.compras.service.ClienteService;
import dev.leoduarte.compras.service.ProdutoService;

@Component
public class CompraResolver implements GraphQLResolver<Compra> {

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	public String status(Compra compra) {
		return "STATUS RESOLVER: " + compra.getStatus();
	}

	public Cliente cliente(Compra compra) {
		return clienteService.findById(compra.getCliente().getId());
	}

	public Produto produto(Compra compra) {
		return produtoService.findById(compra.getProduto().getId());
	}
}
