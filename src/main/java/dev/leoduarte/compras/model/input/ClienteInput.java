package dev.leoduarte.compras.model.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteInput {

	private Long id;
	private String nome;
	private String email;
}
