package com.fiap.ddd.biblioteca.dominio;

public class Email {

	private String endereco;
	
	public Email(String endereco) {
		
		if (!isEmailValido(endereco)) {
			throw new IllegalArgumentException("Email inválido");
		}
		
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return endereco;
	}

	private boolean isEmailValido(String endereco) {
		return endereco != null && !endereco.isBlank();
	}

}
