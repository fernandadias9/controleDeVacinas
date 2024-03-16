package service;

import java.util.ArrayList;

import excepition.ControleVacinasException;
import model.entity.Vacina;
import model.entity.enums.TipoDeReceptor;
import model.repository.VacinaRepository;

public class VacinaService {

	private VacinaRepository vacina = new VacinaRepository();
	
	public Vacina cadastrar(Vacina novaVacina) throws ControleVacinasException{
		if(novaVacina.getPesquisadorResponsavel().getTipo() != TipoDeReceptor.PESQUISADOR) {
			throw new ControleVacinasException("Pesquisador responsável inválido. Verifique o tipo de receptor da pessoa cadastrada.");
		} 
		return vacina.cadastrar(novaVacina);
	}
	
	public ArrayList<Vacina> listarTodas() {
		return vacina.listarTodas();
	}
}
