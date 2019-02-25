package br.sc.senac.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import br.sc.senac.controller.ControladoraVenda;
import br.sc.senac.model.vo.ItemBebidaVO;
import br.sc.senac.model.vo.ItemPratoVO;
import br.sc.senac.model.vo.VendaVO;

public class MenuVenda {

	Scanner tec = new Scanner(System.in);
	private static int senha = 0;
	
	public void apresentarMenuVenda() {
		System.out.println("\n\nFood Truck - Riso & Pasta  \n--------Menu Venda--------");
		System.out.println("\nOpções");
		System.out.println("\n1 - Cadastrar Venda");
		System.out.println("\n2 - Cancelar Venda");
		System.out.println("\n3 - Voltar");
		System.out.println("\nDigite uma opção");
		int opcao = Integer.parseInt(tec.nextLine());
		
		while(opcao != 3) {
			switch(opcao) {
				case 1: {
					this.cadastrarVenda();
					break;
				}
				case 2: {
					this.cancelarVenda();
					break;
				}
				default: {
					System.out.println("\nOpção invalida");
					break;
				}
			}
			System.out.println("\n\nFood Truck - Riso & Pasta  \n--------Menu Venda--------");
			System.out.println("\nOpções");
			System.out.println("\n1 - Cadastrar Venda");
			System.out.println("\n2 - Cancelar Venda");
			System.out.println("\n3 - Voltar");
			System.out.println("\nDigite uma opção");
			opcao = Integer.parseInt(tec.nextLine());
		}
	}

	private void cadastrarVenda() {

		VendaVO vendaVO = new VendaVO();
		vendaVO.setItemPrato(this.pedidoPratos());
		vendaVO.setItemBebidas(this.pedidoBebidas());
		vendaVO.setDataVenda(new Date());
		vendaVO.setSenhaPedido(this.getSenha());
		vendaVO.setFlagVendaCancelada(false);
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		controladoraVenda.cadastrarVendaController(vendaVO);
	}

	private int getSenha() {
		if (senha == 99) {
			senha = 0;
			return senha;
		}else {
			return senha++;
		}
	}

	private ArrayList<ItemBebidaVO> pedidoBebidas() {
		ArrayList<ItemBebidaVO> bebidas = new ArrayList<ItemBebidaVO>();
		System.out.println("\n\nFood Truck - Riso & Pasta \n--------");
		System.out.println("\nOpções: ");
		System.out.println("1 - Incluir Bebida");
		System.out.println("2 - Finalizar pedido Bebida");
		System.out.println("\nDigite sua Opção:");
		int opcao = Integer.parseInt(tec.nextLine());
		while (opcao != 2) {
			switch(opcao) {
				case 1:{
					bebidas = this.incluirBebidas();
					break;
				}
				default:{
					
					break;
				}
			}
			
			System.out.println("\n\nFood Truck - Riso & Pasta \n--------");
			System.out.println("\nOpções: ");
			System.out.println("1 - Incluir Bebida");
			System.out.println("2 - Finalizar pedido Bebida");
			System.out.println("\nDigite sua Opção:");
			opcao = Integer.parseInt(tec.nextLine());
		}
		return bebidas;
	}
	private ArrayList<ItemBebidaVO> incluirBebidas() {
		ArrayList<ItemBebidaVO> itemBebidasVO = new ArrayList<ItemBebidaVO>();
		String continuar = "S";
		while(continuar.equalsIgnoreCase("S")) {
			ItemBebidaVO itemBebidaVO = new ItemBebidaVO();
			System.out.println("Informe o codigo da Bebida: ");
			itemBebidaVO.setIdBebida(Integer.parseInt(tec.nextLine()));
			System.out.println("Informe a Quantidade: ");
			itemBebidaVO.setQuantidade(Integer.parseInt(tec.nextLine()));
			itemBebidasVO.add(itemBebidaVO);
			System.out.println("Deseja incluir mais alguma bebida [S ou N]");
			continuar = tec.nextLine();
		}
		return itemBebidasVO;
	}
	private ArrayList<ItemPratoVO> pedidoPratos() {
		ArrayList<ItemPratoVO> pratos = new ArrayList<ItemPratoVO>();
		System.out.println("\n\nFood Truck - Riso & Pasta \n--------");
		System.out.println("\nOpções: ");
		System.out.println("1 - Incluir Prato");
		System.out.println("2 - Finalizar pedido Prato");
		System.out.println("\nDigite sua Opção:");
		int opcao = Integer.parseInt(tec.nextLine());
		while (opcao != 2) {
			switch(opcao) {
				case 1:{
					pratos = this.incluirPratos();
					break;
				}
				default:{
					
					break;
				}
			}
			
			System.out.println("\n\nFood Truck - Riso & Pasta \n--------");
			System.out.println("\nOpções: ");
			System.out.println("1 - Incluir Prato");
			System.out.println("2 - Finalizar pedido Prato");
			System.out.println("\nDigite sua Opção:");
			opcao = Integer.parseInt(tec.nextLine());
		}
		return pratos;
	}
	private ArrayList<ItemPratoVO> incluirPratos() {
		ArrayList<ItemPratoVO> itemPratosVO = new ArrayList<ItemPratoVO>();
		String continuar = "S";
		while(continuar.equalsIgnoreCase("S")) {
			ItemPratoVO itemPratoVO = new ItemPratoVO();
			System.out.println("Informe o codigo do Prato: ");
			itemPratoVO.setIdPrato(Integer.parseInt(tec.nextLine()));
			System.out.println("Informe a Quantidade: ");
			itemPratoVO.setQuantidade(Integer.parseInt(tec.nextLine()));
			itemPratosVO.add(itemPratoVO);
			System.out.println("Deseja incluir mais algum prato [S ou N]");
			continuar = tec.nextLine();
		}
		
		return itemPratosVO;
	}
	private void cancelarVenda() {
		VendaVO vendaVO = new VendaVO();
		System.out.print("Informe o codigo da venda: ");
		vendaVO.setIdVenda(Integer.parseInt(tec.nextLine()));
		
		ControladoraVenda controladoraVenda = new ControladoraVenda();
		controladoraVenda.cancelarVendaController(vendaVO);
	}
}
