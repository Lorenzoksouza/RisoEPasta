package br.sc.senac.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.sc.senac.controller.ControladoraRelatorio;
import br.sc.senac.model.dto.ProdutoDTO;
import br.sc.senac.model.dto.VendaDTO;
import br.sc.senac.model.vo.VendaVO;

public class MenuRelatorio {
	
	Scanner tec = new Scanner(System.in);
	
	public void apresentarMenuRelatorio() {

		System.out.println("\nFood Truck - Riso & Pasta \n------ Menu Relatorio ------");
		System.out.println("\nOpções:");
		System.out.println("1 - Relatorio de Produtos ");
		System.out.println("2 - Relatorio de vendas canceladas");
		System.out.println("3 - Relatorio de vendas");
		System.out.println("4 - Relatorio de venda por ID");
		System.out.println("5 - Sair");
		System.out.print("\nDigite a opção: ");
		int opcao = Integer.parseInt(tec.nextLine());
		
		while (opcao != 5) {
			switch (opcao) {
				case 1: {
					this.gerarRelatorioProdutos();
					break;
				}
				case 2: {
					this.gerarRelatorioVendasCanceladas();			
					break;
				}
				case 3: {
					this.gerarRelatorioVendas();			
					break;
				}
				case 4: {
					this.gerarRelatorioVendaPorID();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			
			}
			System.out.println("\nFood Truck - Riso & Pasta \n------ Menu Relatorio ------");
			System.out.println("\nOpções:");
			System.out.println("1 - Relatorio de Produtos ");
			System.out.println("2 - Relatorio de vendas canceladas");
			System.out.println("3 - Relatorio de vendas");
			System.out.println("4 - Relatorio de venda por ID");
			System.out.println("5 - Sair");
			System.out.print("\nDigite a opção: ");
			opcao = Integer.parseInt(tec.nextLine());
		}
	}

	private void gerarRelatorioVendaPorID() {
		VendaDTO vendaDTO = new VendaDTO();
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();

		System.out.print("Informe o codigo da venda: ");
		vendaDTO.setQuantidade(Integer.parseInt(tec.nextLine()));
		
		ArrayList<VendaDTO> listaVendaPorIDDTO = controladoraRelatorio.gerarRelatorioVendasPorID(vendaDTO);
		System.out.println("\n-------- RESULTADO DA CONSULTA --------");
		System.out.printf("%3s   %-20s   %-10s  %-10s   %-10s \n", "TIPO", "DESCRIÇÃO", "QNTD", "PREÇO", "SUBTOTAL");
		double total = 0;
		for(int i = 0; i < listaVendaPorIDDTO.size(); i++) {
			listaVendaPorIDDTO.get(i).imprimir();
			total = total + listaVendaPorIDDTO.get(i).getSubtotal();
		}	
		System.out.println("Total: " + total);
	}

	private void gerarRelatorioVendas() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<VendaDTO> listaVendasDTO = controladoraRelatorio.gerarRelatorioVendas();
		System.out.println("\n-------- RESULTADO DA CONSULTA --------");
		System.out.printf("%3s   %-20s   %-10s  %-10s   %-10s \n", "TIPO", "DESCRIÇÃO", "QNTD", "PREÇO", "SUBTOTAL");
		double total = 0;
		for(int i = 0; i < listaVendasDTO.size(); i++) {
			listaVendasDTO.get(i).imprimir();
			total = total + listaVendasDTO.get(i).getSubtotal();
		}	
		System.out.println("Total: " + total);
	}

	private void gerarRelatorioVendasCanceladas() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<VendaDTO> listaVendasDTO = controladoraRelatorio.gerarRelatorioVendasCanceladas();
		System.out.println("\n-------- RESULTADO DA CONSULTA --------");
		System.out.printf("%3s   %-20s   %-10s  %-10s   %-10s \n", "TIPO", "DESCRIÇÃO", "QNTD", "PREÇO", "SUBTOTAL");
		double total = 0;
		for(int i = 0; i < listaVendasDTO.size(); i++) {
			listaVendasDTO.get(i).imprimir();
			total = total + listaVendasDTO.get(i).getSubtotal();
		}	
		System.out.println("Total: " + total);
	}

	private void gerarRelatorioProdutos() {
		ControladoraRelatorio controladoraRelatorio = new ControladoraRelatorio();
		ArrayList<ProdutoDTO> listaProdutosDTO = controladoraRelatorio.gerarRelatorioProdutosController();
		System.out.println("\n-------- RESULTADO DA CONSULTA --------");
		System.out.printf("%3s   %-20s   %-10s   \n", "ITEM", "NOME", "PREÇO");
		for(int i = 0; i < listaProdutosDTO.size(); i++) {
			listaProdutosDTO.get(i).imprimir();
		}		
		System.out.println("Total de produtos: " + listaProdutosDTO.size());
	}
}
