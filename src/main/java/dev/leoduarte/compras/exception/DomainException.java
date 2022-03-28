package dev.leoduarte.compras.exception;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = 2430565419062166159L;

	public DomainException(String message) {
		super(message);
	}

}
