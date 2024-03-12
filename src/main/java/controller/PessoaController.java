package controller;

import java.util.ArrayList;

import excepition.ControleVacinasException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/consultartodas")
	public ArrayList<Pessoa> consultarTodas(){
		 return pessoaService.consultarTodas();
	}
	
	@DELETE
	@Path("/exluir/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean excluir(@PathParam("id") int id){
		 return pessoaService.excluir(id);
	}
}
