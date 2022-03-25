package dev.leoduarte.compras.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.leoduarte.compras.model.Produto;
import dev.leoduarte.compras.model.input.ProdutoInput;
import dev.leoduarte.compras.service.ProdutoService;

@Component
public class ProdutoGraphql implements GraphQLQueryResolver, GraphQLMutationResolver {

	private ProdutoService service;

	public Produto produto(Long id) {
		return service.findById(id);
	}

	public List<Produto> produtos() {
		return service.findAll();
	}

	public Produto saveProduto(ProdutoInput input) {
		return service.save(input);
	}

	public boolean deleteProduto(Long id) {
		return service.deleteById(id);
	}

	@Autowired
	public ProdutoGraphql(ProdutoService service) {
		this.service = service;
	}

}
