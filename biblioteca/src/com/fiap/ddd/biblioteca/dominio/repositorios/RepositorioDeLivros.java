package com.fiap.ddd.biblioteca.dominio.repositorios;

import java.util.List;

import com.fiap.ddd.biblioteca.dominio.Livro;

public interface RepositorioDeLivros {

	public List<Livro> buscarPorCodigo(List<String> codigosLivros);
	
	public Livro buscarPorIsbn(String isbn);
	
	public void salvar(Livro livro);

	public List<Livro> buscarPorTituloOuAutor(String pesquisa);

	public List<Livro> listarTodos();

}
