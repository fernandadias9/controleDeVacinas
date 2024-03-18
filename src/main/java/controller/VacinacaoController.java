package controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Vacinacao;
import service.VacinacaoService;

@Path("/vacinacao")
public class VacinacaoController {
	
	VacinacaoService vacinacao = new VacinacaoService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vacinacao cadastrar(Vacinacao novaVacinacao) {
		return vacinacao.cadastrar(novaVacinacao);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizar")
	public Boolean atualizar(Vacinacao novaVacinacao) {
		return vacinacao.atualizar(novaVacinacao);
	}	
}