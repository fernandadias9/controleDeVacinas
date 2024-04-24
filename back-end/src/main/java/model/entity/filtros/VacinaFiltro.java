package model.entity.filtros;

public class VacinaFiltro {

	private String pais;
	private String nome;
	
	public VacinaFiltro() {
		
	}

	public VacinaFiltro(String pais, String nome) {
		super();
		this.pais = pais;
		this.nome = nome;
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
}