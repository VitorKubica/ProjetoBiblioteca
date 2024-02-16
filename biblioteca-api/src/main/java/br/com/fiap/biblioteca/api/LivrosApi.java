package br.com.fiap.biblioteca.api;

import java.net.URI;
import java.net.URISyntaxException;

import com.fiap.ddd.biblioteca.aplicacao.CadastrarLivro;
import com.fiap.ddd.biblioteca.aplicacao.LivroDTO;
import com.fiap.ddd.biblioteca.aplicacao.PesquisarLivros;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeLivros;
import com.fiap.ddd.biblioteca.infraestrutura.ConexaoJDBC;
import com.fiap.ddd.biblioteca.infraestrutura.RepositorioDeLivrosEmJDBC;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("livros")
@Produces("application/json")
public class LivrosApi {
	private RepositorioDeLivros repositorioDeLivros;
	private CadastrarLivro cadastrarLivro;
	private PesquisarLivros pesquisarLivros;
	
	public LivrosApi() {		
		ConexaoJDBC conexao = 
				new ConexaoJDBC(
						"oracle.jdbc.OracleDriver", 
						"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", 
						"pf4207", 
						System.getenv("senhaBanco")
						);
		repositorioDeLivros = new RepositorioDeLivrosEmJDBC(conexao);
		cadastrarLivro =  new CadastrarLivro(repositorioDeLivros);
		pesquisarLivros = new PesquisarLivros(repositorioDeLivros);
	}
	
	
	
	@POST
	public Response cadastrarNovoLivro(LivroDTO livroDTO) throws URISyntaxException {
		
		try {
			this.cadastrarLivro.cadastrar(livroDTO);
			return Response.created(new URI("livros/" + livroDTO.getIsbn())).build();
		} catch(Exception ex) {
			return Response.serverError().entity(ex.getMessage()).build();
		}
	}
	
	@GET
	public Response listarTodosLivro() {
		return Response.ok(this.pesquisarLivros.listarTodos()).build();
	}
	
	@GET
	@Path("{isbn}")
	public Response buscarPorISBN(@PathParam("isbn") String isbn) {
		LivroDTO retorno = this.pesquisarLivros.pesquisarPorISBN(isbn);
		
		if (retorno == null) {
			return Response.noContent().build();
		} else {
			return Response.ok(retorno).build();
		}
	}
}
