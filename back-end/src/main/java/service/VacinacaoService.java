package service;

import java.util.ArrayList;

import exception.ControleVacinasException;
import model.entity.Vacinacao;
import model.entity.enums.Estagio;
import model.entity.enums.TipoDeReceptor;
import model.repository.PessoaRepository;
import model.repository.VacinacaoRepository;

public class VacinacaoService {

	private VacinacaoRepository vacinacaoRepository = new VacinacaoRepository();
	private final int NOTA_MAXIMA = 5;
	
	public Vacinacao cadastrar(Vacinacao novaVacinacao) throws ControleVacinasException{
		PessoaRepository pessoaRepository = new PessoaRepository();
		
		if(novaVacinacao.getIdPessoa() == 0 || novaVacinacao.getVacina() == null || novaVacinacao.getVacina().getId() == 0) {
			throw new ControleVacinasException("Informe o id da pessoa e o id da vacina aplicada.");
		}
		
		validarReceptor(pessoaRepository, novaVacinacao);
		
		if(novaVacinacao.getAvaliacao() == 0) {
			novaVacinacao.setAvaliacao(NOTA_MAXIMA);
		}
		
		return vacinacaoRepository.cadastrar(novaVacinacao);
	}
	
	public Boolean atualizar(Vacinacao novaVacinacao) throws ControleVacinasException {
		PessoaRepository pessoa = new PessoaRepository();
		
		validarReceptor(pessoa, novaVacinacao);
		
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
	
	public Boolean validarReceptor(PessoaRepository pessoa, Vacinacao novaVacinacao) throws ControleVacinasException {
		boolean pessoaApta = true;
		if(novaVacinacao.getVacina().getEstagio().equals(Estagio.INICIAL) && !pessoa.buscar(novaVacinacao.getIdPessoa()).getTipo().equals(TipoDeReceptor.PESQUISADOR)) {
			throw new ControleVacinasException("Apenas pesquisadores podem receber vacinas em estágio inicial.");
		}
		
		if(novaVacinacao.getVacina().getEstagio().equals(Estagio.TESTES) && pessoa.buscar(novaVacinacao.getIdPessoa()).getTipo().equals(TipoDeReceptor.PUBLICO_GERAL)) {
			throw new ControleVacinasException("Apenas pesquisadores e voluntários podem receber vacinas em estágio de testes.");
		}
		return pessoaApta;
	}
}
