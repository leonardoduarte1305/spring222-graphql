package dev.leoduarte.compras.graphql;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.leoduarte.compras.exception.DomainException;
import dev.leoduarte.compras.model.Compra;
import dev.leoduarte.compras.model.CompraResumo;
import dev.leoduarte.compras.model.input.CompraInput;
import dev.leoduarte.compras.service.CompraService;

@Component
public class CompraGraphql implements GraphQLQueryResolver, GraphQLMutationResolver {

	private CompraService service;

	public Compra compra(Long id) {
		return service.findById(id);
	}

	public List<Compra> compras(int page, int size) {
		return service.findAll(page, size);
	}

	public Compra saveCompra(CompraInput input) {
		if (input.getQuantidade() > 100) {
			throw new DomainException("Não é possível fazer uma compra com mais de 100 itens.");
		}

		return service.save(input);
	}

	public boolean deleteCompra(Long id) {
		return service.deleteById(id);
	}

	public List<CompraResumo> compraRelatorio() {
		return service.findAllComprasRelatorio();
	}

	@Autowired
	public CompraGraphql(CompraService service) {
		this.service = service;
	}
}
