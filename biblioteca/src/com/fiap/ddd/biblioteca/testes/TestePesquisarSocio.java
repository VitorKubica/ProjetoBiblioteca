package com.fiap.ddd.biblioteca.testes;

import java.util.List;

import com.fiap.ddd.biblioteca.aplicacao.PesquisarSocios;
import com.fiap.ddd.biblioteca.aplicacao.SocioDTO;
import com.fiap.ddd.biblioteca.dominio.CPF;
import com.fiap.ddd.biblioteca.dominio.Email;
import com.fiap.ddd.biblioteca.dominio.Socio;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeSocios;
import com.fiap.ddd.biblioteca.infraestrutura.RepositorioDeSociosEmMemoria;

public class TestePesquisarSocio {

	public static void main(String[] args) {
		RepositorioDeSocios repositorio = new RepositorioDeSociosEmMemoria();
		PesquisarSocios casoDeUso = new PesquisarSocios(repositorio);
		
		List<SocioDTO> todosSocios = casoDeUso.listarTodosSocios();
		
		//Deve estar vazio
		System.out.println(todosSocios.size());
		
		repositorio.salvar(
				new Socio(
						"Daniel", 
						new Email("daniel@fiap.com.br"), 
						new CPF("12345")));
		
		repositorio.salvar(
				new Socio(
						"Ana", 
						new Email("ana@fiap.com.br"), 
						new CPF("54321")));
		
		todosSocios = casoDeUso.listarTodosSocios();
		
		//Deve ter dois elementos
		System.out.println(todosSocios.size());
		
		for (SocioDTO socioDTO : todosSocios) {
			System.out.println(socioDTO);
		}
		
		SocioDTO socio = casoDeUso.pesquisarPorCPF("12345");
		
		//Deve ser o Daniel
		System.out.println(socio);
	}

}
