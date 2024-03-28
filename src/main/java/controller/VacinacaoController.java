package controller;

import java.util.ArrayList;

import excepition.ControleVacinasException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Vacinacao;
import service.VacinacaoService;

@Path("/vacinacao")
public class VacinacaoController {
	
	VacinacaoService vacinacaoService = new VacinacaoService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vacinacao cadastrar(Vacinacao novaVacinacao) throws ControleVacinasException {
		return vacinacaoService.cadastrar(novaVacinacao);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizar")
	public Boolean atualizar(Vacinacao novaVacinacao) throws ControleVacinasException {
		return vacinacaoService.atualizar(novaVacinacao);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listartodas")
	public ArrayList<Vacinacao> listarTodas(){
		return vacinacaoService.listarTodas();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{ id }")
	public Vacinacao buscar(@PathParam("id") int id){
		return vacinacaoService.buscar(id);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/excluir/{ id }")
	public Boolean excluir(@PathParam("id") int id) {
		return vacinacaoService.excluir(id);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarporpessoa/{ idPessoa }")
	public ArrayList<Vacinacao> buscarVacinacoesPorPessoa(@PathParam("idPessoa") int idPessoa ){
		return vacinacaoService.buscarVacinacoesPorPessoa(idPessoa);
	}
}