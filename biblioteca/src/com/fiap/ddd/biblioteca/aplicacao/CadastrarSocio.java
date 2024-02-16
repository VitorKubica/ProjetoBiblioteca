package com.fiap.ddd.biblioteca.aplicacao;

import com.fiap.ddd.biblioteca.dominio.CPF;
import com.fiap.ddd.biblioteca.dominio.Email;
import com.fiap.ddd.biblioteca.dominio.Socio;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeSocios;

public class CadastrarSocio {
	
	private RepositorioDeSocios repositorio;
	
	public CadastrarSocio(RepositorioDeSocios repositorio) {
		this.repositorio = repositorio;
	}
	
	public void cadastrar(String nome, String email, String cpf) {
		Socio socioExistente = repositorio.buscarPorCPF(cpf);
		
		if (socioExistente != null) {
			throw new IllegalArgumentException(
					"Já existe um sócio com o cpf informado");
		}
		
		Socio novoSocio = new Socio(nome, new Email(email), new CPF(cpf));
		this.repositorio.salvar(novoSocio);
	}
}
