package dev.leoduarte.compras.graphql;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import dev.leoduarte.compras.model.Compra;
import dev.leoduarte.compras.model.CompraResumo;
import dev.leoduarte.compras.model.input.CompraInput;
import dev.leoduarte.compras.service.ClienteService;
import dev.leoduarte.compras.service.CompraService;
import dev.leoduarte.compras.service.ProdutoService;

@Component
public class CompraGraphql implements GraphQLQueryResolver, GraphQLMutationResolver {

	private CompraService service;
	private ClienteService cliService;
	private ProdutoService prodService;

	public Compra compra(Long id) {
		return service.findById(id);
	}

	public List<Compra> getCompras(int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("quantidade"));
		return service.findAll(pageable);
	}

	public List<CompraResumo> getComprasRelatorio() {
		return service.findAllComprasRelatorio();
	}

	public Compra saveCompra(CompraInput input) {
		ModelMapper m = new ModelMapper();
		Compra c = m.map(input, Compra.class);
		c.setData(new Date());
		c.setCliente(cliService.findById(input.getClienteId()));
		c.setProduto(prodService.findById(input.getProdutoId()));

		return service.save(c);
	}

	public boolean deleteCompra(Long id) {
		return service.deleteById(id);
	}

	@Autowired
	public CompraGraphql(CompraService service, ClienteService clienteService, ProdutoService produtoService) {
		this.service = service;
		this.cliService = clienteService;
		this.prodService = produtoService;
	}

}
