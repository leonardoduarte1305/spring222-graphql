package dev.leoduarte.compras.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class RootController {

	@GetMapping
	public String healthCheck() {
		return "Estou vivo!!";
	}
}
