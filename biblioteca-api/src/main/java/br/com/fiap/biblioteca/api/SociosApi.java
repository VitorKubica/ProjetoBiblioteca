package br.com.fiap.biblioteca.api;

import java.net.URI;
import java.util.List;

import com.fiap.ddd.biblioteca.aplicacao.CadastrarSocio;
import com.fiap.ddd.biblioteca.aplicacao.PesquisarSocios;
import com.fiap.ddd.biblioteca.aplicacao.SocioDTO;
import com.fiap.ddd.biblioteca.dominio.repositorios.RepositorioDeSocios;
import com.fiap.ddd.biblioteca.infraestrutura.RepositorioDeSociosEmJDBC;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

@Path("socios")
@Produces("application/json")
public class SociosApi {
	
	private PesquisarSocios pesquisarSocios;
	private CadastrarSocio cadastrarSocios;
	
	public SociosApi() {
//		RepositorioDeSocios repositorio = 
//				new RepositorioDeSociosEmJDBC(
//						"jdbc:hsqldb:file:c:\\Users\\logonpflocal\\meu_banco_bibiloteca");
		
//		pesquisarSocios = new PesquisarSocios(repositorio);
//		cadastrarSocios = new CadastrarSocio(repositorio);
	}
	
	@POST
	public Response cadastrarSocio(SocioDTO socio) {
		try {
			cadastrarSocios.cadastrar(
				socio.getNome(), socio.getEmail(), socio.getCpf());
			return Response.created(new URI("socios/" + socio.getCpf())).build();
		} catch(Exception ex) {
			return Response.serverError().entity(ex.getMessage()).build();
		}
	}
	
	@GET
	public Response listarTodos() {
		List<SocioDTO> todosOsSocios = pesquisarSocios.listarTodosSocios();
		return Response.ok(todosOsSocios).build();
	}
	
	@GET
	@Path("{cpfSocio}")
	public Response pesquisarPorCPF(@PathParam("cpfSocio") String cpf) {
		
		SocioDTO socio = pesquisarSocios.pesquisarPorCPF(cpf);
		
		if (socio == null) {
			return Response.noContent().build();
//			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.ok(socio).build();
		}
	}
	
	
	
	
	
	
	
	
}
