package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.entity.Vacinacao;
import service.VacinaService;

public class VacinacaoRepository implements BaseRepository<Vacinacao> {

	@Override
	public Vacinacao cadastrar(Vacinacao novaVacinacao) {
		String query = "INSERT INTO vacinacao (idPessoa, data, avaliacao, idVacina) VALUES(?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			preencherParametrosParaInsertOuUpdate(pstmt, novaVacinacao);
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			
			if(resultado.next()) {
				novaVacinacao.setId(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar vacinação.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return novaVacinacao;
	}
	
	@Override
	public Boolean atualizar(Vacinacao vacinacao) {
		boolean retorno = false;
		String query = "UPDATE vacinacao SET idPessoa=?, avaliacao=?, idVacina=?, data=? WHERE id=?";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatement(conn, query);
		
		try {
			preencherParametrosParaInsertOuUpdate(pstmt, vacinacao);
			pstmt.setObject(4,vacinacao.getData());
			pstmt.setInt(5, vacinacao.getId());
			retorno = pstmt.executeUpdate() > 0;
		} catch(SQLException erro) {
			System.out.println("Erro ao atualizar vacinação.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closePreparedStatement(pstmt);
			Banco.closeConnection(conn);
		}		
		return retorno;
	}
	
	@Override
	public ArrayList<Vacinacao> listarTodas(){
		ArrayList<Vacinacao> listaVacinacoes = new ArrayList<Vacinacao>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "SELECT * FROM vacinacao";
		
		try {
			ResultSet resultado = stmt.executeQuery(query);
			
			while(resultado.next()) {
				Vacinacao vacinacao = new Vacinacao();
				preencherParametrosParaListarTodasOuBuscar(resultado, vacinacao);
				listaVacinacoes.add(vacinacao);
			}
		} catch (SQLException erro) {
			System.out.println("Não foi possível listar as vacinações.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaVacinacoes;
	}
	
	@Override
	public Vacinacao buscar(int id) {
		Vacinacao vacinacao = null;
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM vacinacao WHERE id = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			
			if(resultado.next()) {
				preencherParametrosParaListarTodasOuBuscar(resultado, vacinacao);
			}			
		} catch(SQLException erro) {
			System.out.println("Erro ao buscar vacinação.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return vacinacao;
	}
	
	@Override
	public Boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM vacinacao WHERE id = " + id;
		
		try {
			excluiu = stmt.executeUpdate(query) > 0;
		} catch(SQLException erro) {
			System.out.println("Não foi possível excluir o registrode vacinação.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}
	
	public ArrayList<Vacinacao> buscarVacinacoesPorPessoa(int idPessoa){
		ArrayList<Vacinacao> listaVacinacoes = new ArrayList<Vacinacao>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		String query = "SELECT * FROM vacinacao WHERE idPessoa = " + idPessoa;
		
		try {
			ResultSet resultado = stmt.executeQuery(query);
			
			while(resultado.next()) {
				Vacinacao vacinacao = new Vacinacao();
				preencherParametrosParaListarTodasOuBuscar(resultado, vacinacao);
				listaVacinacoes.add(vacinacao);
			}
		} catch (SQLException erro) {
			System.out.println("Não foi possível listar as vacinações.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaVacinacoes;
	}
	
	public void preencherParametrosParaInsertOuUpdate(PreparedStatement pstmt, Vacinacao novaVacinacao) throws SQLException {
		pstmt.setInt(1,novaVacinacao.getIdPessoa());		
		pstmt.setInt(2,novaVacinacao.getAvaliacao());
		pstmt.setInt(3,novaVacinacao.getVacina().getId());
	}
	
	public void preencherParametrosParaListarTodasOuBuscar(ResultSet resultado, Vacinacao vacinacao) throws SQLException {
		VacinaService vacina = new VacinaService();
		
		vacinacao.setId(resultado.getInt("id"));
		vacinacao.setIdPessoa(resultado.getInt("idPessoa"));
		vacinacao.setVacina(vacina.buscar(resultado.getInt("idVacina")));
		vacinacao.setData(resultado.getDate("data").toLocalDate());
		vacinacao.setAvaliacao(resultado.getInt("avaliacao"));
	}
}
