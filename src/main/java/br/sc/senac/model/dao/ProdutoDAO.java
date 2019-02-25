package br.sc.senac.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.sc.senac.model.dto.ProdutoDTO;

public class ProdutoDAO {

	public ArrayList<ProdutoDTO> gerarRelatorioProdutosDAO() {
		Connection conn = Banco.getConnection();
		Statement stmt = Banco.getStatement(conn);
		ResultSet resultado = null;
		ArrayList<ProdutoDTO> produtosDTO = new ArrayList<ProdutoDTO>();
		String query = "SELECT PRATO.IDPRATO,PRATO.NOME,PRATO.PRECO FROM PRATO UNION ALL (SELECT BEBIDA.IDBEBIDA,BEBIDA.NOME,BEBIDA.PRECO FROM BEBIDA)";
		
		try {
			resultado = stmt.executeQuery(query);
			int id = 1;
			while(resultado.next()) {
				ProdutoDTO produtoDTO = new ProdutoDTO();
				produtoDTO.setIdProduto(id);
				produtoDTO.setNome(resultado.getString(2));
				produtoDTO.setPreco(Double.parseDouble(resultado.getString(3)));
				id ++;
				produtosDTO.add(produtoDTO);
			}
		} catch (SQLException e) {
			System.out.println("Erro ao executar o relatorio dos produtos.");
			e.printStackTrace();
		} finally{
			Banco.closeResultSet(resultado);
			Banco.closeStatement(stmt);
			Banco.closeConnection(conn);
		}
		return produtosDTO;
	}

}
