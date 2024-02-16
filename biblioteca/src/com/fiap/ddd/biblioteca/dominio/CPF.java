package com.fiap.ddd.biblioteca.dominio;

public class CPF {
	
	private String numero;
	
	public CPF(String numero) {
		
		if (!isCPFValido(numero)) {
			throw new IllegalArgumentException("CPF inválido");
		}
		
		this.numero = numero;
	}
	
	@Override
	public String toString() {
		return numero;
	}

	private boolean isCPFValido(String numero) {
		return numero != null && !numero.isBlank();
	}

}
