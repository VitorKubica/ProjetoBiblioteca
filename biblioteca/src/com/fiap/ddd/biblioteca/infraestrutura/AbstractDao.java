package com.fiap.ddd.biblioteca.infraestrutura;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class AbstractDao {
	private ConexaoJDBC conexao;
	
	public AbstractDao(ConexaoJDBC conexao) {
		this.conexao = conexao;
	}
	
	public Connection criarConexao() throws ClassNotFoundException, SQLException {
		return this.conexao.criarConexao();
	}
}
