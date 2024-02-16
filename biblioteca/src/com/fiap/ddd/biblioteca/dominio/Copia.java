package com.fiap.ddd.biblioteca.dominio;

public class Copia {
	private Livro livro;
	private int edicao;
	private String codigo;
	
	public Copia(Livro livro, int edicao, String codigo) {
		if (livro == null) {
			throw new IllegalArgumentException("Livro deve ser informado");
		}
		
		if (edicao <= 0) {
			throw new IllegalArgumentException("Edição inválida");
		}
		
		if (codigo == null || codigo.isBlank()) {
			throw new IllegalArgumentException("Código inválido");
		}
	}
	
	public Livro getLivro() {
		return livro;
	}
	
	public int getEdicao() {
		return edicao;
	}
	
	public String getCodigo() {
		return codigo;
	}
}
