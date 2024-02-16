package com.fiap.ddd.biblioteca.aplicacao;

// DTO - Data transfer object
public class SocioDTO {
	
	private String cpf;
	private String nome;
	private String email;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "SocioDTO [cpf=" + cpf + ", nome=" + nome + ", email=" + email + "]";
	}
	
	
	
	
	
	

}
