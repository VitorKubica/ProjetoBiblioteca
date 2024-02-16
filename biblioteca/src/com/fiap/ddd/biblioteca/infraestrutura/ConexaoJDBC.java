package com.fiap.ddd.biblioteca.infraestrutura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoJDBC {
	private String driver;
	private String connectionString;
	private String usuario;
	private String senha;
	
	public ConexaoJDBC(String driver, String connectionString, String usuario, String senha) {
		this.driver = driver;
		this.connectionString = connectionString;
		this.usuario = usuario;
		this.senha = senha;
	}
	
	public Connection criarConexao() throws ClassNotFoundException, SQLException {
		Class.forName(this.driver);
		return DriverManager.getConnection(this.connectionString, this.usuario, this.senha);
	}
}
