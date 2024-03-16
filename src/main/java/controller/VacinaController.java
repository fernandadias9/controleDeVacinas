package controller;

import java.util.ArrayList;

import excepition.ControleVacinasException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Vacina;
import service.VacinaService;

@Path("/vacina")
public class VacinaController {

	private VacinaService vacina = new VacinaService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vacina cadastrar(Vacina novaVacina) throws ControleVacinasException {
		return vacina.cadastrar(novaVacina);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listartodas")
	public ArrayList<Vacina> listarTodas() {
		return vacina.listarTodas();
	}
}
