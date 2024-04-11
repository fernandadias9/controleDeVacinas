package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.entity.Pais;

public class PaisRepository {

	public Pais cadastrar(Pais novaPais) {
		String query = "INSERT INTO pais (sigla, nome) VALUES (?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			pstmt.setString(1, novaPais.getSigla());
			pstmt.setObject(2, novaPais.getNome());
			
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			
			if(resultado.next()) {
				novaPais.setId(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar pais.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return novaPais;
	}
	
	public Pais buscar(int id) {
		Pais pais = new Pais();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM pais WHERE id = " + id;
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				pais.setId(resultado.getInt("id"));
				pais.setSigla(resultado.getString("sigla"));
				pais.setNome(resultado.getString("nome"));
				
			}
		} catch(SQLException erro) {
			System.out.println("Erro ao buscar país.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pais;
	}
	
	public boolean verificarPaisExiste(Pais pais) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		boolean retorno = false;
		String query = "SELECT sigla FROM pais WHERE sigla = '" + pais.getSigla() + "'";
		try {
			resultado = stmt.executeQuery(query); 
			if(resultado.next()) { 
				retorno = true;
			}
		} catch(SQLException erro) {
			System.out.println("\nErro ao executar a query do método verificarPaisExiste.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;		
	}	
}
