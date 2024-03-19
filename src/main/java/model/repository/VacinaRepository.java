package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.entity.Vacina;
import model.entity.enums.Estagio;

public class VacinaRepository {

	public Vacina cadastrar(Vacina novaVacina) {
		
		String query = "INSERT INTO vacina (nome, paisOrigem, idPesquisador, idEstagio, dataInicio) VALUES (?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			preencherParametrosParaInsertOuUpdate(pstmt, novaVacina);
			
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			
			if(resultado.next()) {
				novaVacina.setId(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar vacina.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		
		return novaVacina;
	}
	
	public Boolean atualizar(Vacina vacina) {
		boolean resultado = false;
		String query = "UPDATE vacina SET nome=?, paisOrigem=?, idPesquisador=?, idEstagio=?, dataInicio=? WHERE id=?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, query);
		
		try {
			preencherParametrosParaInsertOuUpdate(pstmt, vacina);
			pstmt.setInt(6, vacina.getId());
			resultado = pstmt.executeUpdate() > 0;
		} catch(SQLException erro) {
			System.out.println("Não foi possível atualizar vacina.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return resultado;
	}
	
	public ArrayList<Vacina> listarTodas() {		
		ArrayList<Vacina> listaVacinas = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM vacina";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				Vacina vacina = new Vacina();
				preencherParametrosParaBuscarOuListarTodas(resultado, vacina);				
				listaVacinas.add(vacina);
			}
		} catch(SQLException erro) {
			System.out.println("Erro ao executar consultar todas as vacinas.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		
		return listaVacinas;
	}
	
	public Vacina buscar(int id) {
		Vacina vacina = new Vacina();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM vacina WHERE id = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				preencherParametrosParaBuscarOuListarTodas(resultado, vacina);
			}
		} catch(SQLException erro) {
			System.out.println("Erro ao buscar vacina.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vacina;
	}
	
	private void preencherParametrosParaInsertOuUpdate(PreparedStatement pstmt
			, Vacina novaVacina) throws SQLException {
		
		pstmt.setString(1, novaVacina.getNome());
		pstmt.setString(2, novaVacina.getPaisOrigem());
		pstmt.setInt(3, novaVacina.getPesquisadorResponsavel().getId());
		if(novaVacina.getEstagio().equals(Estagio.INICIAL)) {
			pstmt.setInt(4, 1);
		}
		
		if(novaVacina.getEstagio().equals(Estagio.TESTES)) {
			pstmt.setInt(4, 2);
		}
		
		if(novaVacina.getEstagio().equals(Estagio.APLICACAO)) {
			pstmt.setInt(4, 3);
		}
		pstmt.setObject(5, novaVacina.getDataInicio());
	}
	
	public void preencherParametrosParaBuscarOuListarTodas(ResultSet resultado, Vacina vacina) throws SQLException {
		PessoaRepository pesquisador = new PessoaRepository();
		
		vacina.setId(resultado.getInt("id"));
		vacina.setNome(resultado.getString("nome"));
		vacina.setPaisOrigem(resultado.getString("paisOrigem"));
		vacina.setPesquisadorResponsavel(pesquisador.buscar(resultado.getInt("idPesquisador")));
		if(resultado.getInt("idEstagio") == 1) {
			vacina.setEstagio(Estagio.INICIAL);
		}
		if(resultado.getInt("idEstagio") == 2) {
			vacina.setEstagio(Estagio.TESTES);
		}
		if(resultado.getInt("idEstagio") == 3) {
			vacina.setEstagio(Estagio.APLICACAO);
		}		
		vacina.setDataInicio(resultado.getDate("dataInicio").toLocalDate());
	}
}
