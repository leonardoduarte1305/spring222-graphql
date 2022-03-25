package dev.leoduarte.compras.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoInput {

	private Long id;
	private String nome;
	private Float valor;
}
