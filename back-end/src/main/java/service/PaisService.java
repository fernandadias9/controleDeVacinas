package service;

import java.util.ArrayList;

import exception.ControleVacinasException;
import model.entity.Pais;
import model.repository.PaisRepository;

public class PaisService {

	PaisRepository paisRepository = new PaisRepository();
	
	public Pais cadastrar(Pais novoPais) throws ControleVacinasException {
		if(paisRepository.verificarPaisExiste(novoPais)) {
			throw new ControleVacinasException("País já cadastrado.");
		} else {
			paisRepository.cadastrar(novoPais);
		}
		return novoPais;
		}
	
	public Pais buscar(int id ) {
		return paisRepository.buscar(id);
	}
	
	public ArrayList<Pais> listarTodos(){
		return paisRepository.listarTodos();
	}
}