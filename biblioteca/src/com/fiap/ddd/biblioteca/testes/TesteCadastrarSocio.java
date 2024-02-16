package com.fiap.ddd.biblioteca.testes;

import com.fiap.ddd.biblioteca.aplicacao.CadastrarSocio;
import com.fiap.ddd.biblioteca.dominio.Socio;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeSocios;
import com.fiap.ddd.biblioteca.infraestrutura.RepositorioDeSociosEmMemoria;

public class TesteCadastrarSocio {

	public static void main(String[] args) {
		RepositorioDeSocios repositorio = new RepositorioDeSociosEmMemoria();
		CadastrarSocio casoDeUso = new CadastrarSocio(repositorio);
		
		Socio socioNaoExistente = repositorio.buscarPorCPF("134556");
		Socio socio = repositorio.buscarPorCPF("123.456.789-00");
		
		
		//Nao deve trazer um socio que nao existe
		System.out.println(socioNaoExistente);
		
		//Neste ponto, deve ser nulo
		System.out.println(socio);
		casoDeUso.cadastrar("Daniel", "daniel.costa@fiap.com.br", "123.456.789-00");
		
		socio = repositorio.buscarPorCPF("123.456.789-00");
		
		//Neste ponto, deve existir
		System.out.println(socio);
	}

}
