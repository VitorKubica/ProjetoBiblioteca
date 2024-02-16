package com.fiap.ddd.biblioteca.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		try (Connection conn = 
				DriverManager.getConnection(
						"jdbc:hsqldb:file:c:\\Users\\logonpflocal\\meu_banco_bibiloteca");
			 Statement stmt = conn.createStatement()) {
			stmt.execute(
					"create table socio( "
					+ "cpf varchar(40) primary key, "
					+ "nome varchar(100) not null, "
					+ "email varchar(100) not null) ");
			
		}
	}
}
