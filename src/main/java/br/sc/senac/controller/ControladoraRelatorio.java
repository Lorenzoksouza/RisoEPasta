package br.sc.senac.controller;

import java.util.ArrayList;

import br.sc.senac.model.bo.ProdutoBO;
import br.sc.senac.model.bo.VendaBO;
import br.sc.senac.model.dto.ProdutoDTO;
import br.sc.senac.model.dto.VendaDTO;
import br.sc.senac.model.vo.VendaVO;

public class ControladoraRelatorio {


	public ArrayList<ProdutoDTO> gerarRelatorioProdutosController() {

		ProdutoBO produtoBO = new ProdutoBO();
		return produtoBO.gerarRelatorioProdutos();
		
	}

	public ArrayList<VendaDTO> gerarRelatorioVendas() {
		
		VendaBO vendaBO = new VendaBO();
		return vendaBO.gerarRelatorioVendas();
		
	}

	public ArrayList<VendaDTO> gerarRelatorioVendasCanceladas() {
		
		VendaBO vendaBO = new VendaBO();
		return vendaBO.gerarRelatorioVendasCanceladas();
		
	}

	public ArrayList<VendaDTO> gerarRelatorioVendasPorID(VendaDTO vendaDTO) {
		
		VendaBO vendaBO = new VendaBO();
		return vendaBO.gerarRelatorioVendaPorID(vendaDTO);
		
	}

	
}