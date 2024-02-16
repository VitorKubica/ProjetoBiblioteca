package com.fiap.ddd.biblioteca.infraestrutura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fiap.ddd.biblioteca.dominio.Livro;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeLivros;

public class RepositorioDeLivrosEmJDBC extends AbstractDao implements RepositorioDeLivros {
	
	public RepositorioDeLivrosEmJDBC(ConexaoJDBC conexao) {
		super(conexao);
	}

	@Override
	public List<Livro> buscarPorCodigo(List<String> codigosLivros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Livro buscarPorIsbn(String isbn) {
		try (Connection conn = this.criarConexao();
			 PreparedStatement select = conn.prepareStatement("select * from livro where isbn = ?");) {
			select.setString(1, isbn);
			
			ResultSet resultado = select.executeQuery();
			
			if (resultado.next()) {				
				Livro retorno = transformarRegistroDoBancoEmLivro(resultado);
				return retorno;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public List<Livro> listarTodos() {		
		List<Livro> retorno = new ArrayList<>();
		
		try (Connection conexaoComBanco = this.criarConexao();
			 Statement comando = conexaoComBanco.createStatement();) {
			ResultSet registros = comando.executeQuery("select * from livro");
			
			while(registros.next()) {
				Livro livro = transformarRegistroDoBancoEmLivro(registros);
				retorno.add(livro);
			}
			
			return retorno;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
	
	private Livro transformarRegistroDoBancoEmLivro(
			ResultSet registroDoBanco) throws SQLException {
		String titulo = registroDoBanco.getString("titulo");
		String autor = registroDoBanco.getString("autor");
		String isbn = registroDoBanco.getString("isbn");
		Livro livro = new Livro(titulo, autor, isbn);
		return livro;
	}

	@Override
	public void salvar(Livro livro) {
		try (Connection conn = this.criarConexao();
			 PreparedStatement pstm = conn.prepareStatement(
					 "insert into livro(isbn, titulo, autor) values (?, ?, ?)")) {
			pstm.setString(1, livro.getIsbn());
			pstm.setString(2, livro.getTitulo());
			pstm.setString(3, livro.getAutor());
			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Livro> buscarPorTituloOuAutor(String pesquisa) {
		// TODO Auto-generated method stub
		return null;
	}

}
