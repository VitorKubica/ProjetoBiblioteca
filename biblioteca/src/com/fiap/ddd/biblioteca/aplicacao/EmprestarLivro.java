package com.fiap.ddd.biblioteca.aplicacao;

import java.util.List;

import com.fiap.ddd.biblioteca.dominio.Emprestimo;
import com.fiap.ddd.biblioteca.dominio.Livro;
import com.fiap.ddd.biblioteca.dominio.Socio;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeEmprestimos;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeLivros;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeSocios;

public class EmprestarLivro {
	private RepositorioDeSocios repoSocios;
	private RepositorioDeEmprestimos repoEmprestimos;
	private RepositorioDeLivros repoLivros;
	
	public void emprestarLivros(String cpfSocio, List<String> codigosLivros) {
		Socio socio = this.repoSocios.buscarPorCPF(cpfSocio);
		
		if (socio == null) {
			throw new IllegalArgumentException("Não existe cliente com o cpf informado");
		}
		
		if (socio.possuiEmprestimosPendentes()) {
			throw new IllegalArgumentException("Não é permitido emprestar novos livros ao sócio");
		}
		
		List<Livro> livros = this.repoLivros.buscarPorCodigo(codigosLivros);
		
		Emprestimo emprestimo = new Emprestimo(socio, livros);
		this.repoEmprestimos.salvar(emprestimo);		
	}
}
