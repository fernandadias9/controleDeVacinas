package model.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import model.entity.enums.TipoDeReceptor;

public class Pessoa {

	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private String sexo;
	private String cpf;
	private TipoDeReceptor tipo;
	private Pais pais;
	private ArrayList<Vacinacao> vacinacoes;
	
	public Pessoa() {
		super();
	}

	public Pessoa(int id, String nome, LocalDate dataNascimento, String sexo, String cpf, TipoDeReceptor tipo,
			Pais pais, ArrayList<Vacinacao> vacinacoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipo = tipo;
		this.pais = pais;
		this.vacinacoes = vacinacoes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public TipoDeReceptor getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeReceptor tipo) {
		this.tipo = tipo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public ArrayList<Vacinacao> getVacinacoes() {
		return vacinacoes;
	}

	public void setVacinacoes(ArrayList<Vacinacao> vacinacoes) {
		this.vacinacoes = vacinacoes;
	}
}