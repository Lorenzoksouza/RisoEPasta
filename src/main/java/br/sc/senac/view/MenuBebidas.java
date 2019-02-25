package br.sc.senac.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.sc.senac.controller.ControladoraBebida;
import br.sc.senac.model.vo.BebidaVO;

public class MenuBebidas {

	Scanner tec = new Scanner(System.in);
	public void apresentarMenuBebidas() {
		
		System.out.println("\n\nFood Truck - Riso & Pasta \n------ Menu Cadastro de Bebidas ------");
		System.out.println("\nOpções");
		
		System.out.println("1 - Cadastrar Bebidas");
		System.out.println("2 - Consultar Bebidas");
		System.out.println("3 - Atualizar Bebidas");
		System.out.println("4 - Excluir Bebidas");
		System.out.println("5 - Voltar");
		System.out.print("\nDigite a Opção: ");

		int opcao = Integer.parseInt(tec.nextLine());

		while (opcao != 5) {
			switch (opcao) {
				case 1: {
					this.cadastrarBebida();
					break;
				}
				case 2: {
					this.consultarBebida();
					break;
				}
				case 3: {
					this.atualizarBebida();
					break;
				}
				case 4: {
					this.excluirBebida();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("1 - Cadastrar Bebidas");
			System.out.println("2 - Consultar Bebidas");
			System.out.println("3 - Atualizar Bebidas");
			System.out.println("4 - Excluir Bebidas");
			System.out.println("5 - Voltar");
			System.out.print("\nDigite a Opção: ");

			opcao = Integer.parseInt(tec.nextLine());
		}
	}
	private void cadastrarBebida() {
		BebidaVO bebidaVO = new BebidaVO();
		System.out.print("\nDigite o nome da Bebida: ");
		bebidaVO.setNome(tec.nextLine());
		System.out.print("\nDigite o preço da Bebida: ");
		bebidaVO.setPreco(Double.parseDouble(tec.nextLine()));
		
		ControladoraBebida controladoraBebida = new ControladoraBebida();
		controladoraBebida.cadastrarBebidaController(bebidaVO);
		
	}
	private void consultarBebida() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todos as bebidas");
		System.out.println("2 - Consultar uma bebida especifico");
		System.out.println("3 - Voltar");
		System.out.print("\nDigite a Opção: ");

		int opcao = Integer.parseInt(tec.nextLine());

		ControladoraBebida controladoraBebida = new ControladoraBebida();
			
		while (opcao != 3) {
			switch (opcao) {
				case 1: {
					ArrayList<BebidaVO> listaBebidasVO = controladoraBebida.consultarTodasBebidasController();
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n%3s   %-20s   %-10s   \n", "ID", "NOME", "PREÇO");
					for(int i = 0; i < listaBebidasVO.size(); i++) {
						listaBebidasVO.get(i).imprimir();
					}
					break;
				}
				case 2: {
					BebidaVO bebidaVO = new BebidaVO();
					System.out.print("Informe o codigo da bebida: ");
					bebidaVO.setIdBebida(Integer.parseInt(tec.nextLine()));
					
					BebidaVO bebida = controladoraBebida.consultarBebidasController(bebidaVO);;
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n%3s   %-20s   %-10s   \n", "ID", "NOME", "PREÇO");
					bebida.imprimir();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("\nInforme o tipo de consulta a ser realizada");
			System.out.println("1 - Consultar todos as bebidas");
			System.out.println("2 - Consultar uma bebida especifico");
			System.out.println("3 - Voltar");
			System.out.print("\nDigite a Opção: ");

			opcao = Integer.parseInt(tec.nextLine());
		}
	}
	
	private void atualizarBebida() {
		BebidaVO bebidaVO = new BebidaVO();
		System.out.print("\nInforme o código da Bebida: ");
		bebidaVO.setIdBebida(Integer.parseInt(tec.nextLine()));
		System.out.print("\nDigite o nome da Bebida: ");
		bebidaVO.setNome(tec.nextLine());
		System.out.print("\nDigite o preço da Bebida: ");
		bebidaVO.setPreco(Double.parseDouble(tec.nextLine()));
		
		ControladoraBebida controladoraBebida = new ControladoraBebida();
		controladoraBebida.atualizarBebida(bebidaVO);
		
	}
	
	private void excluirBebida() {
		BebidaVO bebidaVO = new BebidaVO();
		System.out.print("\nInforme o codigo da Bebida: ");
		bebidaVO.setIdBebida(Integer.parseInt(tec.nextLine()));
		
		ControladoraBebida controladoraBebida = new ControladoraBebida();
		controladoraBebida.excluirBebida(bebidaVO);
		
	}
}
