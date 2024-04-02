package controller;

import exception.ControleVacinasException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.entity.Pais;
import model.entity.Pessoa;
import service.PaisService;

@Path("/pais")
public class PaisController {

private PaisService paisService = new PaisService();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Pais cadastrar(Pais novoPais) throws ControleVacinasException {
		 return paisService.cadastrar(novoPais);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscar/{id}")
	public Pais buscar(@PathParam("id") int id){
		 return paisService.buscar(id);
	}
}
