package service;

import java.util.ArrayList;

import exception.ControleVacinasException;
import model.entity.Pessoa;
import model.repository.PessoaRepository;

public class PessoaService {

	private PessoaRepository pessoaRepository = new PessoaRepository();
	VacinacaoService vacinacao = new VacinacaoService();
	
	public Pessoa cadastrar(Pessoa novaPessoa) throws ControleVacinasException {
		
		validarCampos(novaPessoa);
		if(pessoaRepository.verificarCpfExiste(novaPessoa)) {
			throw new ControleVacinasException("Pessoa já cadastrada.");
		} else {
			pessoaRepository.cadastrar(novaPessoa);			
		}		
				
		return novaPessoa;
	}
	
	public Boolean atualizar(Pessoa novaPessoa) throws ControleVacinasException{
		if(!novaPessoa.getCpf().equals(pessoaRepository.buscar(novaPessoa.getId()).getCpf())) {
			if(pessoaRepository.verificarCpfExiste(novaPessoa)) {
				throw new ControleVacinasException("Pessoa já cadastrada.");
			}
		}	
		return pessoaRepository.atualizar(novaPessoa);
	}
	
	public ArrayList<Pessoa> consultarTodas(){
		return pessoaRepository.listarTodas();		
	}
	
	public Pessoa buscar(int id ) {
		Pessoa pessoa = pessoaRepository.buscar(id);
		pessoa.setVacinacoes(vacinacao.buscarVacinacoesPorPessoa(id));
		return pessoa;
	}
	
	public boolean excluir(int id) throws ControleVacinasException {
		if(!vacinacao.buscarVacinacoesPorPessoa(id).isEmpty()) {
			throw new ControleVacinasException("Não é possível excluir pessoa com vacinações cadastradas.");
		}
		return pessoaRepository.excluir(id);
	}
	
	public void validarCampos(Pessoa novaPessoa) throws ControleVacinasException {
		if(novaPessoa.getNome() == null || novaPessoa.getNome().isEmpty()) {
			throw new ControleVacinasException("Campo nome não pode ficar vazio.");
		}
		if(novaPessoa.getDataNascimento() == null) {
			throw new ControleVacinasException("Campo data de nascimento não pode ficar vazio.");
		}
		if(novaPessoa.getSexo() == null || novaPessoa.getSexo().isEmpty()) {
			throw new ControleVacinasException("Campo sexo não pode ficar vazio.");
		}
		if(novaPessoa.getCpf() == null || novaPessoa.getCpf().isEmpty() || novaPessoa.getCpf().length() != 11) {
			throw new ControleVacinasException("Campo cpf necessita de 11 dígitos.");
		}
		if(novaPessoa.getTipo() == null) {
			throw new ControleVacinasException("Campo tipo não pode ficar vazio.");
		}
		if(novaPessoa.getPais() == null) {
			throw new ControleVacinasException("Campo país não pode ficar vazio.");
		}
	}
}