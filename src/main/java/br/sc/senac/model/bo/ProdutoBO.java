package br.sc.senac.model.bo;

import java.util.ArrayList;

import br.sc.senac.model.dao.ProdutoDAO;
import br.sc.senac.model.dto.ProdutoDTO;

public class ProdutoBO {

	public ArrayList<ProdutoDTO> gerarRelatorioProdutos() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ArrayList<ProdutoDTO> listaProdutosDTO = produtoDAO.gerarRelatorioProdutosDAO();
		if(listaProdutosDTO.isEmpty()) {
			System.out.println("\nLista de produtos está vazia!");
		}
		return listaProdutosDTO;
	}
}
