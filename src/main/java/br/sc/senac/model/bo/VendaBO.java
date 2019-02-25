package br.sc.senac.model.bo;

import java.util.ArrayList;

import br.sc.senac.model.dao.VendaDAO;
import br.sc.senac.model.dto.VendaDTO;
import br.sc.senac.model.vo.VendaVO;

public class VendaBO {

	public void cadastrarVendaBO(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		if (vendaDAO.existeRegistroDaVenda(vendaVO)) {
			System.out.println("\nVenda ja cadastrada!");
		}else{
			int resultado = vendaDAO.cadastrarVendaDAO(vendaVO);
			if(resultado != 0) {
				vendaVO.setIdVenda(resultado);
				boolean resultadoPrato = vendaDAO.cadastrarItemPratoDAO(vendaVO);
				if(resultadoPrato) {
					boolean resultadoBebida = vendaDAO.cadastrarItemBebidaDAO(vendaVO);
					if(resultadoBebida) {
						System.out.println("Venda cadastrada com sucesso");
					}else {
						System.out.println("\nNão foi possivel incluir o pedido das Bebidas!");
					}
				}else {
					System.out.println("\nNão foi possivel incluir o pedido dos Pratos!");
				}
			}else {
				System.out.println("\nErro ao cadastrar a venda");
			}
		}
	}

	public void cancelarVendaBO(VendaVO vendaVO) {
		VendaDAO vendaDAO = new VendaDAO();
		if (vendaDAO.existeRegistroDaVendaPorID(vendaVO)) {
			int resultado = vendaDAO.cancelarVendaDAO(vendaVO);
			if (resultado == 1) {
				System.out.println("Venda cancelada com sucesso!");
			}else {
				System.out.println("Não foi possivel cancelar a venda");
			}
		}else{
			System.out.println("\nVenda não existe na base de dados");
		}
	}

	public ArrayList<VendaDTO> gerarRelatorioVendas() {
		VendaDAO vendaDTO = new VendaDAO();
		ArrayList<VendaDTO> listaVendasDTO = vendaDTO.gerarRelatorioVendasDAO();
		if(listaVendasDTO.isEmpty()) {
			System.out.println("\nLista de vendas está vazia!");
		}
		return listaVendasDTO;
	}

	public ArrayList<VendaDTO> gerarRelatorioVendasCanceladas() {
		VendaDAO vendaDTO = new VendaDAO();
		ArrayList<VendaDTO> listaVendasCanceladasDTO = vendaDTO.gerarRelatorioVendasCanceladasDAO();
		if(listaVendasCanceladasDTO.isEmpty()) {
			System.out.println("\nLista de vendas canceladas está vazia!");
		}
		return listaVendasCanceladasDTO;
	}

	public ArrayList<VendaDTO> gerarRelatorioVendaPorID(VendaDTO vendaDTO2) {
		VendaDAO vendaDTO = new VendaDAO();
		ArrayList<VendaDTO> listaVendaPorIDDTO = vendaDTO.gerarRelatorioVendaPorIDDAO(vendaDTO2);
		if(listaVendaPorIDDTO.isEmpty()) {
			System.out.println("\nLista de vendas canceladas está vazia!");
		}
		return listaVendaPorIDDTO;
	}

}
