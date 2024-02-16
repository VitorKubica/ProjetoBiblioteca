package com.porto.fiap.ddd.biblioteca.cadastro;

import com.fiap.ddd.biblioteca.aplicacao.CadastrarLivro;
import com.fiap.ddd.biblioteca.aplicacao.CadastrarSocio;
import com.fiap.ddd.biblioteca.aplicacao.PesquisarLivros;
import com.fiap.ddd.biblioteca.aplicacao.PesquisarSocios;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeLivros;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeSocios;
import com.fiap.ddd.biblioteca.infraestrutura.RepositorioDeLivrosEmMemoria;
import com.fiap.ddd.biblioteca.infraestrutura.RepositorioDeSociosEmJDBC;

public class Main {
	private static final String TITULO_JANELA = "Biblioteca";
	private static final int POSICAO_X = 400;
	private static final int POSICAO_Y = 300;
	private static final int WIDTH = 400;
	private static final int HEIGHT = 400;
	
	public static void main(String[] args) {	
		RepositorioDeSocios repositorioDeSocios =
			new RepositorioDeSociosEmJDBC(null);
		CadastrarSocio servicoCadastrarSocio = 
				new CadastrarSocio(repositorioDeSocios);
		
		PesquisarSocios servicoPesquisarSocios =
				 new PesquisarSocios(repositorioDeSocios);
		
		RepositorioDeLivros repositorioDeLivros = 
				new RepositorioDeLivrosEmMemoria();
		CadastrarLivro servicoCadastrarLivro = 
				new CadastrarLivro(repositorioDeLivros);
		
		FormularioCadastroNovoSocio formNovoSocio = 
				new FormularioCadastroNovoSocio(
						TITULO_JANELA, 
						POSICAO_X, 
						POSICAO_Y, 
						WIDTH, 
						HEIGHT, 
						servicoCadastrarSocio);

		FormularioPesquisaSocio formPesquisaSocios =
				new FormularioPesquisaSocio(
						TITULO_JANELA, POSICAO_X, POSICAO_Y, WIDTH, HEIGHT, 
						servicoPesquisarSocios);
		
		FormularioCadastroNovoLivro formNovoLivro =
				new FormularioCadastroNovoLivro(
						TITULO_JANELA, POSICAO_X, POSICAO_Y, WIDTH, HEIGHT, 
						servicoCadastrarLivro);	
		
		PesquisarLivros servicoPesquisarLivros = new PesquisarLivros(repositorioDeLivros);
		
		FormularioPesquisaLivro formPesquisaLivros = 
				new FormularioPesquisaLivro(TITULO_JANELA, POSICAO_X, POSICAO_Y, WIDTH, HEIGHT, servicoPesquisarLivros);
		
		FormularioPrincipal formularioPrincipal = new FormularioPrincipal(
				TITULO_JANELA, POSICAO_X, POSICAO_Y, WIDTH, HEIGHT, 
				formNovoSocio,
				formPesquisaSocios,
				formNovoLivro,
				formPesquisaLivros);
		formularioPrincipal.ativar();
	}

}
