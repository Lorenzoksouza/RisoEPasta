package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.sc.senac.model.vo.PratoVO;

public class PratoDAO {

	public boolean existeRegistoPorNome(String nome) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT * FROM PRATO WHERE NOME LIKE'" + nome + "'";
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query que verifica a existencia de prato por nome!");
			e.printStackTrace();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return false;
	}

	public int cadastrarPratoDAO(PratoVO pratoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "INSERT INTO PRATO (NOME,PRECO) VALUES ('" +	pratoVO.getNome() + "', " + pratoVO.getPreco() +")";
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("\nErro ao executar o cadastro do prato!");
			e.printStackTrace();
		} finally {	
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return resultado;
	}

	public boolean existeRegistroPorIdPrato(int idPrato) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT idprato FROM prato WHERE idprato = " + idPrato;
		
		try {
			resultado = stmt.executeQuery(query);
			if(resultado.next()) {
				return true;
			}
		} catch (SQLException e) {
			System.out.println("\nErro ao executar a query de existencia de prato por id.");
			e.printStackTrace();
		} finally {
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}		
		return false;
	}

	public int excluirPratoDAO(PratoVO pratoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "DELETE FROM Prato WHERE idprato = "+ pratoVO.getIdPrato();
		try {
			resultado = stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Erro ao executar a query de exclusão de prato.");
			e.printStackTrace();
		}
		
		return resultado;
	}

	public int atualizarPratoDAO(PratoVO pratoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		int resultado = 0;
		String query = "UPDATE prato SET nome = '" + pratoVO.getNome() + "', preco = " + pratoVO.getPreco() + " WHERE idprato = " + pratoVO.getIdPrato();
	
		try {
				resultado = stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("\nErro ao executar a query de atualização do prato.");
				e.printStackTrace();
			} finally {
				Banco.closeStatement(stmt);
				Banco.closeConnection(conn);
			}
		return resultado;

	}
	public ArrayList<PratoVO> consultarTodosPratosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<PratoVO> pratosVO = new ArrayList<PratoVO>();
		String query = "SELECT idprato,nome,preco FROM prato";
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				PratoVO pratoVO = new PratoVO();
				pratoVO.setIdPrato(Integer.parseInt(resultado.getString(1)));
				pratoVO.setNome(resultado.getString(2));
				pratoVO.setPreco(Double.parseDouble(resultado.getString(3)));
				pratosVO.add(pratoVO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a consulta dos Pratos.");
			e.printStackTrace();
		} finally{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return pratosVO;
	}

	public PratoVO consultarPratoDAO(PratoVO pratoVO) {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		PratoVO prato = new PratoVO();

		String query = "SELECT idprato,nome,preco FROM prato WHERE idprato = " + pratoVO.getIdPrato();
		
		try {
			resultado = stmt.executeQuery(query);
			while(resultado.next()) {
				prato.setIdPrato(Integer.parseInt(resultado.getString(1)));
				prato.setNome(resultado.getString(2));
				prato.setPreco(Double.parseDouble(resultado.getString(3)));
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar a consulta do Prato.");
			e.printStackTrace();
		} finally{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return prato;
	}

}
