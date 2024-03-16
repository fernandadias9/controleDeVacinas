package service;

import model.entity.Vacinacao;
import model.repository.VacinacaoRepository;

public class VacinacaoService {

	private VacinacaoRepository vacinacao = new VacinacaoRepository();
	
	public Vacinacao cadastrar(Vacinacao novaVacinacao) {
		return vacinacao.cadastrar(novaVacinacao);
	}
}
