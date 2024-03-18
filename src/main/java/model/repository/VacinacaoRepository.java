package model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.entity.Vacinacao;

public class VacinacaoRepository {

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
	
	public void preencherParametrosParaInsertOuUpdate(PreparedStatement pstmt, Vacinacao novaVacinacao) throws SQLException {
		pstmt.setInt(1,novaVacinacao.getIdPessoa());
		pstmt.setObject(2,novaVacinacao.getData());
		pstmt.setInt(3,novaVacinacao.getAvaliacao());
		pstmt.setInt(4,novaVacinacao.getVacina().getId());
	}
}
