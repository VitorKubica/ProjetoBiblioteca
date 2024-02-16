package com.fiap.ddd.biblioteca.aplicacao;

import java.util.ArrayList;
import java.util.List;

import com.fiap.ddd.biblioteca.dominio.Livro;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeLivros;

public class PesquisarLivros {
	private RepositorioDeLivros repositorio;
	
	public PesquisarLivros(RepositorioDeLivros repositorio) {
		this.repositorio = repositorio;
	}
	
	public List<LivroDTO> pesquisarPorTituloOuAutor(String pesquisa) {
		
		if (pesquisa == null || pesquisa.length() < 3) {
			throw new IllegalArgumentException("Pesquisa deve ter no mínimo três caracteres");
		}
		
		List<Livro> livros = repositorio.buscarPorTituloOuAutor(pesquisa);
		
		List<LivroDTO> retorno = new ArrayList<>();
		
		for (Livro livro: livros) {
			LivroDTO dto = transformarEmDTO(livro);
			retorno.add(dto);
		}
		
		return retorno;
	}

	private LivroDTO transformarEmDTO(Livro livro) {
		LivroDTO dto = new LivroDTO();
		dto.setTitulo(livro.getTitulo());
		dto.setAutor(livro.getAutor());
		dto.setIsbn(livro.getIsbn());
		
		return dto;
	}

	public LivroDTO pesquisarPorISBN(String isbn) {
		Livro livro = this.repositorio.buscarPorIsbn(isbn);
		
		if (livro == null) {
			return null;
		}
		
		return transformarEmDTO(livro);
	}
	
	public List<LivroDTO> listarTodos() {
		List<Livro> livros = repositorio.listarTodos();
		
		List<LivroDTO> retorno = new ArrayList<>();
		
		for (Livro livro : livros) {
			retorno.add(transformarEmDTO(livro));
		}
		
		return retorno;
	}
	
}
