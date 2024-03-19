package service;

import java.util.ArrayList;

import excepition.ControleVacinasException;
import model.entity.Vacina;
import model.entity.enums.TipoDeReceptor;
import model.repository.VacinaRepository;

public class VacinaService {

	private VacinaRepository vacinaRepository = new VacinaRepository();
	
	public Vacina cadastrar(Vacina novaVacina) throws ControleVacinasException{
		if(novaVacina.getPesquisadorResponsavel().getTipo() != TipoDeReceptor.PESQUISADOR) {
			throw new ControleVacinasException("Pesquisador responsável inválido. Verifique o tipo de receptor da pessoa cadastrada.");
		} 
		return vacinaRepository.cadastrar(novaVacina);
	}
	
	public Boolean atualizar(Vacina vacina) throws ControleVacinasException {
		if(vacina.getPesquisadorResponsavel().getTipo() != TipoDeReceptor.PESQUISADOR) {
			throw new ControleVacinasException("Pesquisador responsável inválido. Verifique o tipo de receptor da pessoa cadastrada.");
		} 
		return vacinaRepository.atualizar(vacina);
	}
	
	public ArrayList<Vacina> listarTodas() {
		return vacinaRepository.listarTodas();
	}
	
	public Vacina buscar(int id) {
		return vacinaRepository.buscar(id);
	}
}
