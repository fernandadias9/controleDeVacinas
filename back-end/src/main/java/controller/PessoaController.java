package controller;

import java.util.ArrayList;

import exception.ControleVacinasException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Pessoa;
import service.PessoaService;

@Path("/pessoa")
public class PessoaController {
	
	private PessoaService pessoaService = new PessoaService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pessoa cadastrar(Pessoa novaPessoa) throws ControleVacinasException {
		 return pessoaService.cadastrar(novaPessoa);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizar")
	public Boolean atualizar(Pessoa pessoa) throws ControleVacinasException {
		return pessoaService.atualizar(pessoa);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listartodas")
	public ArrayList<Pessoa> consultarTodas(){
		 return pessoaService.consultarTodas();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public Pessoa buscar(@PathParam("id") int id){
		 return pessoaService.buscar(id);
	}
	
	@DELETE
	@Path("/exluir/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean excluir(@PathParam("id") int id)throws ControleVacinasException {
		 return pessoaService.excluir(id);
	}
}
