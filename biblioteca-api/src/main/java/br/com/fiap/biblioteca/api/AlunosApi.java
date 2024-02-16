package br.com.fiap.biblioteca.api;

import java.net.URI;
import java.net.URISyntaxException;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.core.Response.StatusType;

//alunos
@Path("alunos")
public class AlunosApi {

	//GET listar todos alunos
	@GET
	public Response listarTodos() {
		System.out.println("Entrou em listar todos");
		return Response.ok().build();
		//return Response.status(Status.OK).build();
	}
	//GET alunos/{matricula} buscar por matrícula
	@GET
	@Path("{matricula}")
	public Response buscarPorMatricula(
			@PathParam("matricula") String matricula) {
		System.out.println("Entrou em buscar por matrícula: " + matricula);
		return Response.ok().build();
	}
	//POST cadastrar novo aluno
	@POST
	public Response cadastrarAluno(AlunoDto aluno) throws URISyntaxException {
		System.out.println("Entrou em cadastrar aluno " 
				+ aluno.getMatricula() + " - " + aluno.getNome());
		return Response.created(new URI("idFake")).build();
	}
	//PUT alunos/{matricula} para atualizar aluno
	@PUT
	@Path("{matricula}")
	public Response atualizarAluno(
			@PathParam("matricula") String matricula, AlunoDto aluno) {
		System.out.println("Entrou em atualizar aluno " + matricula + " - " 
				+ aluno.getMatricula() + " - " + aluno.getNome());
		return Response.ok().build();
	}
}
