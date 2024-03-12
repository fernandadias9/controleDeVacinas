package service;

import java.util.ArrayList;

import excepition.ControleVacinasException;
import model.entity.Pessoa;
import model.repository.PessoaRepository;

public class PessoaService {

	private PessoaRepository pessoaRepository = new PessoaRepository();
	
	public Pessoa cadastrar(Pessoa novaPessoa) throws ControleVacinasException {
		
		if(pessoaRepository.verificarCpfExiste(novaPessoa)) {
			throw new ControleVacinasException("Pessoa já cadastrada.");
		} else {
			pessoaRepository.cadastrar(novaPessoa);			
		}
		
		if(novaPessoa.getNome() == null) {
			throw new ControleVacinasException("Campo nome não pode ficar vazio.");
		}
		if(novaPessoa.getDataNascimento() == null) {
			throw new ControleVacinasException("Campo data de nascimento não pode ficar vazio.");
		}
		if(novaPessoa.getSexo() == null) {
			throw new ControleVacinasException("Campo sexo não pode ficar vazio.");
		}
		if(novaPessoa.getCpf() == null) {
			throw new ControleVacinasException("Campo cpf não pode ficar vazio.");
		}
		if(novaPessoa.getTipo() == null) {
			throw new ControleVacinasException("Campo tipo não pode ficar vazio.");
		}		
		return novaPessoa;
	}
	
	public ArrayList<Pessoa> consultarTodas(){
		return pessoaRepository.consultarTodas();		
	}
	
	public boolean excluir(int id) {
		return pessoaRepository.excluir(id);
	}
}