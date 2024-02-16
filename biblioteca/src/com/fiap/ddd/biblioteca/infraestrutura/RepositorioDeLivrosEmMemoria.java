package com.fiap.ddd.biblioteca.infraestrutura;

import java.util.ArrayList;
import java.util.List;

import com.fiap.ddd.biblioteca.dominio.Livro;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeLivros;

public class RepositorioDeLivrosEmMemoria implements RepositorioDeLivros {

	private List<Livro> livros = new ArrayList<>();
	
	@Override
	public List<Livro> buscarPorCodigo(List<String> codigosLivros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livro buscarPorIsbn(String isbn) {
		
		for (Livro livroExistente: livros) {
			if (livroExistente.getIsbn().equals(isbn)) {
				return livroExistente;
			}
		}
		
		return null;
	}

	@Override
	public void salvar(Livro livro) {
		this.livros.add(livro);
	}

	@Override
	public List<Livro> buscarPorTituloOuAutor(String pesquisa) {
		
		List<Livro> retorno = new ArrayList<>();
		
		for (Livro livroExistente: livros) {
			
			if (livroExistente.getAutor().toLowerCase().contains(pesquisa.toLowerCase()) 
			 || livroExistente.getTitulo().toLowerCase().contains(pesquisa.toLowerCase())) {
				retorno.add(livroExistente);
			}
		}
		
		return retorno;
	}

	@Override
	public List<Livro> listarTodos() {
		return this.livros;
	}


}
