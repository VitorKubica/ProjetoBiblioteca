package com.fiap.ddd.biblioteca.infraestrutura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fiap.ddd.biblioteca.dominio.CPF;
import com.fiap.ddd.biblioteca.dominio.Email;
import com.fiap.ddd.biblioteca.dominio.Socio;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeSocios;

public class RepositorioDeSociosEmJDBC extends AbstractDao implements RepositorioDeSocios {
	
	public RepositorioDeSociosEmJDBC(ConexaoJDBC conexao) {
		super(conexao);
	}
	
	@Override
	public Socio buscarPorCPF(String cpf) {
		try {
			try(Connection conn = this.criarConexao()) {
				try (PreparedStatement comando = conn.prepareStatement(
						"select * from socio where cpf = ?;")) {
					comando.setString(1, cpf);
					
					try (ResultSet registros = comando.executeQuery()) {						
						while(registros.next()) {
							String cpfBanco = registros.getString("cpf");
							String nome = registros.getString("nome");
							String email = registros.getString("email");
							return new Socio(nome, new Email(email), new CPF(cpfBanco));
						}
						
						return null;
					}
					
				}
			}
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void salvar(Socio novoSocio) {
		try {			
			try(Connection conn = this.criarConexao();
				PreparedStatement comando = 
					conn.prepareStatement(
						"insert into socio(cpf, nome, email) values(?, ?, ?);")) {
				comando.setString(1, novoSocio.getCpf().toString());
				comando.setString(2, novoSocio.getNome());
				comando.setString(3, novoSocio.getEmail().toString());
				comando.executeUpdate();
			}
			
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	@Override
	public List<Socio> listarTodos() {
		try {			
			try(Connection conn = this.criarConexao()) {
				try (Statement comando = conn.createStatement()) {					
					List<Socio> retorno = new ArrayList<>();
					
					try (ResultSet registros = comando.executeQuery("select * from socio;")) {						
						while(registros.next()) {
							String cpfBanco = registros.getString("cpf");
							String nome = registros.getString("nome");
							String email = registros.getString("email");
							retorno.add(new Socio(nome, new Email(email), new CPF(cpfBanco)));
						}
						
						return retorno;
					}
				}
			}
		} catch(Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
