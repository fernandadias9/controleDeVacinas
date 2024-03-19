package service;

import java.util.ArrayList;

import model.entity.Vacinacao;
import model.repository.VacinacaoRepository;

public class VacinacaoService {

	private VacinacaoRepository vacinacaoRepository = new VacinacaoRepository();
	
	public Vacinacao cadastrar(Vacinacao novaVacinacao) {
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
