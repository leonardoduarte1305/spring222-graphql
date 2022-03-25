package dev.leoduarte.compras.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CompraResumo {

	private Long id;
	private String cliente;
	private String produto;
	private Integer quantidade;
}
