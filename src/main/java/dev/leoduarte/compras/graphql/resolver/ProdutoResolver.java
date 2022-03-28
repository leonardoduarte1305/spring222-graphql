package dev.leoduarte.compras.graphql.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLResolver;

import dev.leoduarte.compras.model.Produto;

@Component
public class ProdutoResolver implements GraphQLResolver<Produto> {

	public String valorReais(Produto p) {
		return "R$ " + p.getValor();
	}
}
