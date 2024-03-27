package service;

import java.time.LocalDate;
import java.util.ArrayList;

import excepition.ControleVacinasException;
import model.entity.Vacinacao;
import model.repository.VacinacaoRepository;

public class VacinacaoService {

	private VacinacaoRepository vacinacaoRepository = new VacinacaoRepository();
	private final int NOTA_MAXIMA = 5;
	
	public Vacinacao cadastrar(Vacinacao novaVacinacao) throws ControleVacinasException{
		
		if(novaVacinacao.getIdPessoa() == 0 || novaVacinacao.getVacina() == null || novaVacinacao.getVacina().getId() == 0) {
			throw new ControleVacinasException("Informe o id da pessoa e o id da vacina aplicada.");
		}
		
		novaVacinacao.setData(LocalDate.now());
		
		if(novaVacinacao.getAvaliacao() == 0) {
			novaVacinacao.setAvaliacao(NOTA_MAXIMA);
		}
		
		return vacinacaoRepository.cadastrar(novaVacinacao);
	}
	
	public Boolean atualizar(Vacinacao novaVacinacao) {
		return vacinacaoRepository.atualizar(novaVacinacao);
	}
	
	public ArrayList<Vacinacao> listarTodas(){
		return vacinacaoRepository.listarTodas();
	}
	
	public Vacinacao buscar(int id) {
		return vacinacaoRepository.buscar(id);
	}
	
	public Boolean excluir(int id) {
		return vacinacaoRepository.excluir(id);
	}
	
	public ArrayList<Vacinacao> buscarVacinacoesPorPessoa(int idPessoa){
		return vacinacaoRepository.buscarVacinacoesPorPessoa(idPessoa);
	}
}
