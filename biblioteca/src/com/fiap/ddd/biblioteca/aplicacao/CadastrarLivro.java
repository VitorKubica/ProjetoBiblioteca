package com.fiap.ddd.biblioteca.aplicacao;

import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeLivros;
import com.fiap.ddd.biblioteca.dominio.Livro;

public class CadastrarLivro {
	private RepositorioDeLivros repositorio;
	
	public CadastrarLivro(RepositorioDeLivros repositorio) {
		this.repositorio = repositorio;
	}
	
	public void cadastrar(LivroDTO novoLivroDTO) {
		
		Livro livroExistente = this.repositorio.buscarPorIsbn(novoLivroDTO.getIsbn());
		
		if (livroExistente != null) {
			throw new IllegalArgumentException("Já existe livro cadastro com o ISBN informado");
		}
		
		Livro novoLivro = 
				new Livro(
						novoLivroDTO.getTitulo(), novoLivroDTO.getAutor(), novoLivroDTO.getIsbn());
		this.repositorio.salvar(novoLivro);
	}
}
