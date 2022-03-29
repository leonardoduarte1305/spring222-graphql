package dev.leoduarte.compras.graphql;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/")
@RestController
public class RootController {

	@GetMapping
	public String root() {
		return "Acesse: /playground ou /graphiql para conferir e testar todos os recursos disponíveis.";
	}
}
