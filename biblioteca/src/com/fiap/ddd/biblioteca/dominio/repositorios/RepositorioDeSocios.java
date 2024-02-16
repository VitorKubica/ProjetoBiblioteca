package com.fiap.ddd.biblioteca.dominio.repositorios;

import java.util.List;

import com.fiap.ddd.biblioteca.dominio.Socio;

public interface RepositorioDeSocios {

	public Socio buscarPorCPF(String cpf);

	public void salvar(Socio novoSocio);

	public List<Socio> listarTodos();
}
