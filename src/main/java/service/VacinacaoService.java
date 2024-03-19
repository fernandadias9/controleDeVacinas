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
}
