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
import model.entity.Vacina;
import model.entity.filtros.VacinaFiltro;
import service.VacinaService;

@Path("/vacina")
public class VacinaController {

	private VacinaService vacinaService = new VacinaService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Vacina cadastrar(Vacina novaVacina) throws ControleVacinasException {
		return vacinaService.cadastrar(novaVacina);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/atualizar")
	public Boolean atualizar(Vacina vacina) throws ControleVacinasException {
		return vacinaService.atualizar(vacina);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/listartodas")
	public ArrayList<Vacina> listarTodas() {
		return vacinaService.listarTodas();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/filtrar")
	public ArrayList<Vacina> buscarComFiltro(VacinaFiltro filtro) {
		return vacinaService.buscarComFiltro(filtro);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{ id }")
	public Vacina buscar(@PathParam("id") int id) {
		return vacinaService.buscar(id);
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/excluir/{ id }")
	public Boolean excluir(@PathParam("id") int id) throws ControleVacinasException {
		return vacinaService.excluir(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/contarRegistros")
	public int contarRegistros(VacinaFiltro filtro) {
		return vacinaService.contarRegistros(filtro);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/totalPaginas")
	public int totalPaginas(VacinaFiltro filtro) {
		return vacinaService.totalPaginas(filtro);
	}
}