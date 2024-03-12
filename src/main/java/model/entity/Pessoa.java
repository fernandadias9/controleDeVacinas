package model.entity;

import java.time.LocalDate;

import model.entity.enums.TipoDeReceptor;

public class Pessoa {

	private int id;
	private String nome;
	private LocalDate dataNascimento;
	private String sexo;
	private String cpf;
	private TipoDeReceptor tipo;
	
	public Pessoa() {
		super();
	}

	public Pessoa(int id, String nome, LocalDate dataNascimento, String sexo, String cpf, TipoDeReceptor tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.sexo = sexo;
		this.cpf = cpf;
		this.tipo = tipo;
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

	public void setNome(String name) {
		this.nome = name;
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
}