package service;

import java.util.ArrayList;

import exception.ControleVacinasException;
import model.entity.Vacina;
import model.entity.enums.TipoDeReceptor;
import model.entity.filtros.VacinaFiltro;
import model.repository.VacinaRepository;
import model.repository.VacinacaoRepository;

public class VacinaService {

	private VacinaRepository vacinaRepository = new VacinaRepository();
	private VacinacaoRepository vacinacao = new VacinacaoRepository();
	
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
	
	public ArrayList<Vacina> buscarComFiltro(VacinaFiltro filtro) {
		return vacinaRepository.buscarComFiltro(filtro);
	}
	
	public Vacina buscar(int id) {
		return vacinaRepository.buscar(id);
	}
	
	public Boolean excluir(int id) throws ControleVacinasException {
		if(vacinacao.verificarSeVacinaTemDoseAplicada(id)) {
			throw new ControleVacinasException("Não é possível excluir vacina já aplicada.");
		}
		return vacinaRepository.excluir(id);
	}
	
	public int contarRegistros(VacinaFiltro filtro) {
		return vacinaRepository.contarRegistros(filtro);
	}
	
	public int totalPaginas(VacinaFiltro filtro) {
		return vacinaRepository.totalPaginas(filtro);
	}
}
