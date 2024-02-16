package com.fiap.ddd.biblioteca.aplicacao;

import java.util.ArrayList;
import java.util.List;

import com.fiap.ddd.biblioteca.dominio.Socio;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeSocios;

public class PesquisarSocios {
	private RepositorioDeSocios repositorio;
	
	public PesquisarSocios(RepositorioDeSocios repositorio) {
		this.repositorio = repositorio;
	}
	
	public SocioDTO pesquisarPorCPF(String cpf) {
		Socio socio = this.repositorio.buscarPorCPF(cpf);
		
		if (socio == null) {
			return null;
		}

		return transformarEmDTO(socio);
	}

	public List<SocioDTO> listarTodosSocios() {
		List<Socio> todosOsSocios = repositorio.listarTodos();
		List<SocioDTO> retorno = new ArrayList<>();
		
		for (Socio socio : todosOsSocios) {
			retorno.add(transformarEmDTO(socio));
		}
		
		return retorno;
	}
	
	private SocioDTO transformarEmDTO(Socio socio) {
		SocioDTO dto = new SocioDTO();
		dto.setNome(socio.getNome());
		dto.setEmail(socio.getEmail().toString());
		dto.setCpf(socio.getCpf().toString());
		return dto;
	}
}
