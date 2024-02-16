package com.fiap.ddd.biblioteca.dominio;

public class Socio {
	private String nome;
	private Email email;
	private CPF cpf;
	
	public Socio(String nome, Email email, CPF cpf) {
		
		if (nome == null || nome.isBlank()) {
			throw new RuntimeException("Nome deve ser informado");
		}
		
		if (email == null) {
			throw new RuntimeException("Email deve ser informado");
		}
		
		if (cpf == null) {
			throw new RuntimeException("CPF deve ser informado");
		}
		
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Email getEmail() {
		return email;
	}
	
	public CPF getCpf() {
		return cpf;
	}
	
	

	@Override
	public String toString() {
		return "Socio [nome=" + nome + ", email=" + email + ", cpf=" + cpf + "]";
	}

	public boolean possuiEmprestimosPendentes() {
		// TODO Auto-generated method stub
		return false;
	}

}
