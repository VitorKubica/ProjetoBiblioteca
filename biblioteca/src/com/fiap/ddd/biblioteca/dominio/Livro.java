package com.fiap.ddd.biblioteca.dominio;

import java.util.ArrayList;
import java.util.List;

public class Livro {
	private String titulo;
	private String autor;
	private String isbn;
	private List<Copia> copias = new ArrayList<>();
	
	public Livro(String titulo, String autor, String isbn) {
		if (titulo == null || titulo.isBlank()) {
			throw new IllegalArgumentException("Título não pode estar vazio");
		}
		
		if (autor == null || autor.isBlank()) {
			throw new IllegalArgumentException("Autor não pode estar vazio");
		}
		
		if (isbn == null || isbn.isBlank()) {
			throw new IllegalArgumentException("ISBN não pode estar vazio");
		}
		
		this.titulo = titulo;
		this.autor = autor;
		this.isbn = isbn;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getAutor() {
		return this.autor;
	}
	
	public String getIsbn() {
		return this.isbn;
	}	
	
	public void adicionarCopia(Copia copia) {
		if (copia == null) {
			throw new IllegalArgumentException("Cópia inválida");
		}
		
		for (Copia copiaExistente : copias) {
			if (copiaExistente.getCodigo().equals(copia.getCodigo())) {
				throw new IllegalArgumentException("Já existe cópia com o código informado");
			}
		}
		
		this.copias.add(copia);
	}
}
