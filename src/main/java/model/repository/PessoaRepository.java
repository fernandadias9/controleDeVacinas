package model.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.entity.Pessoa;
import model.entity.enums.TipoDeReceptor;

public class PessoaRepository {

	public Pessoa cadastrar(Pessoa novaPessoa) {
		String query = "INSERT INTO pessoa (nome, dataNascimento, sexo, cpf, id_tipo) VALUES (?, ?, ?, ?, ?)";
		Connection conn = Banco.getConnection();
		PreparedStatement pstmt = Banco.getPreparedStatementWithPk(conn, query);
		try {
			preencherParametrosParaInsertOuUpdate(pstmt, novaPessoa);
			
			pstmt.execute();
			ResultSet resultado = pstmt.getGeneratedKeys();
			
			if(resultado.next()) {
				novaPessoa.setId(resultado.getInt(1));
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao cadastrar pessoa.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(pstmt);
			Banco.closeConnection(conn);
		}
		return novaPessoa;
	}
	
	public ArrayList<Pessoa> consultarTodas() {
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		String query = " SELECT * FROM pessoa";
		
		try{
			resultado = stmt.executeQuery(query);
			while(resultado.next()){
				Pessoa pessoa = new Pessoa();
				
				pessoa.setId(Integer.parseInt(resultado.getString("id")));
				pessoa.setNome(resultado.getString("nome"));
				pessoa.setDataNascimento(resultado.getDate("dataNascimento").toLocalDate()); 
				pessoa.setSexo(resultado.getString("sexo"));
				pessoa.setCpf(resultado.getString("cpf"));
				if(resultado.getInt("id_tipo") == 1) {
					pessoa.setTipo(TipoDeReceptor.PESQUISADOR);
				}
				if(resultado.getInt("id_tipo") == 2) {
					pessoa.setTipo(TipoDeReceptor.VOLUNTARIO);
				}
				if(resultado.getInt("id_tipo") == 3) {
					pessoa.setTipo(TipoDeReceptor.PUBLICO_GERAL);
				}				
				listaPessoas.add(pessoa);
			}
		} catch (SQLException erro){
			System.out.println("Erro ao executar consultar todas as jogadors");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return listaPessoas;
	}
	
	public Pessoa buscar(int id) {
		Pessoa pessoa = new Pessoa();
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		
		ResultSet resultado = null;
		String query = "SELECT * FROM pessoa WHERE id = " + id;
		
		try{
			resultado = stmt.executeQuery(query);
			
			if(resultado.next()) {
				pessoa.setId(Integer.parseInt(resultado.getString("id")));
				pessoa.setNome(resultado.getString("nome"));
				pessoa.setDataNascimento(resultado.getDate("dataNascimento").toLocalDate()); 
				pessoa.setSexo(resultado.getString("sexo"));
				pessoa.setCpf(resultado.getString("cpf"));
				if(resultado.getInt("id_tipo") == 1) {
					pessoa.setTipo(TipoDeReceptor.PESQUISADOR);
				}
				if(resultado.getInt("id_tipo") == 2) {
					pessoa.setTipo(TipoDeReceptor.VOLUNTARIO);
				}
				if(resultado.getInt("id_tipo") == 3) {
					pessoa.setTipo(TipoDeReceptor.PUBLICO_GERAL);
				}				
			}
						
		} catch (SQLException erro){
				System.out.println("Erro ao executar a busca por id.");
				System.out.println("Erro: " + erro.getMessage());
		} finally {
				Banco.closeResultSet(resultado);
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
		}
		return pessoa;
	}
	
	public boolean excluir(int id) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		boolean excluiu = false;
		String query = "DELETE FROM pessoa WHERE id = " + id;
		try {
			if(stmt.executeUpdate(query) == 1) {
				excluiu = true;
			}
		} catch (SQLException erro) {
			System.out.println("Erro ao excluir pessoa");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return excluiu;
	}
	
	private void preencherParametrosParaInsertOuUpdate(PreparedStatement pstmt
			, Pessoa novaPessoa) throws SQLException {
		
		pstmt.setString(1, novaPessoa.getNome());
		pstmt.setObject(2, novaPessoa.getDataNascimento());
		pstmt.setString(3, novaPessoa.getSexo());
		pstmt.setString(4, novaPessoa.getCpf());
		if(novaPessoa.getTipo().equals(TipoDeReceptor.PESQUISADOR)) {
			pstmt.setInt(5, 1);
		}
		
		if(novaPessoa.getTipo().equals(TipoDeReceptor.VOLUNTARIO)) {
			pstmt.setInt(5, 2);
		}
		
		if(novaPessoa.getTipo().equals(TipoDeReceptor.PUBLICO_GERAL)) {
			pstmt.setInt(5, 3);
		}
	}
	
	public boolean verificarCpfExiste(Pessoa pessoa) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		boolean retorno = false;
		String query = "SELECT cpf FROM pessoa WHERE cpf = '" + pessoa.getCpf() + "'";
		try {
			resultado = stmt.executeQuery(query); 
			if(resultado.next()) { 
				retorno = true;
			}
		} catch(SQLException erro) {
			System.out.println("\nErro ao executar a query do método verificarCpfExiste.");
			System.out.println("Erro: " + erro.getMessage());
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return retorno;		
	}	
}