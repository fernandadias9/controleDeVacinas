package model.entity.filtros;

import java.time.LocalDate;

public class VacinaFiltro {

	private String pais;
	private String nome;
	private String pesquisadorResponsavel;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private String estagio;
	private Double avaliacaoMinima;
	private Double avaliacaoMaxima;
	
	public VacinaFiltro() {
		
	}

	public VacinaFiltro(String pais, String nome, String pesquisadorResponsavel, LocalDate dataInicio, LocalDate dataFinal, String estagio, Double avaliacaoMinima, Double avaliacaoMaxima) {
		super();
		this.pais = pais;
		this.nome = nome;
		this.pesquisadorResponsavel = pesquisadorResponsavel;
		this.dataInicial = dataInicio;
		this.dataFinal = dataFinal;
		this.estagio = estagio;
		this.avaliacaoMinima = avaliacaoMinima;
		this.avaliacaoMaxima = avaliacaoMaxima;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPesquisadorResponsavel() {
		return pesquisadorResponsavel;
	}

	public void setPesquisadorResponsavel(String pesquisadorResponsavel) {
		this.pesquisadorResponsavel = pesquisadorResponsavel;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}

	public LocalDate getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}

	public String getEstagio() {
		return estagio;
	}

	public void setEstagio(String estagio) {
		this.estagio = estagio;
	}

	public Double getAvaliacaoMinima() {
		return avaliacaoMinima;
	}

	public void setAvaliacaoMinima(Double avaliacaoMinima) {
		this.avaliacaoMinima = avaliacaoMinima;
	}

	public Double getAvaliacaoMaxima() {
		return avaliacaoMaxima;
	}

	public void setAvaliacaoMaxima(Double avaliacaoMaxima) {
		this.avaliacaoMaxima = avaliacaoMaxima;
	}	
}