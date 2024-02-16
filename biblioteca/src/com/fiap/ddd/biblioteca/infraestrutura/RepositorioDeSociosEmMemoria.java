package com.fiap.ddd.biblioteca.infraestrutura;

import java.util.ArrayList;
import java.util.List;

import com.fiap.ddd.biblioteca.dominio.Socio;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeSocios;

public class RepositorioDeSociosEmMemoria implements RepositorioDeSocios {

	private List<Socio> socios = new ArrayList<>();
	
	@Override
	public Socio buscarPorCPF(String cpf) {
		
		for (Socio socio : socios) {
			if (socio.getCpf().toString().equals(cpf)) {
				return socio;
			}	
		}
		
		return null;
	}

	@Override
	public void salvar(Socio novoSocio) {
		this.socios.add(novoSocio);
	}

	@Override
	public List<Socio> listarTodos() {
		return socios;
	}
}
