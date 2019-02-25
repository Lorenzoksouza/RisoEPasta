package br.sc.senac.view;

import java.util.ArrayList;
import java.util.Scanner;

import br.sc.senac.controller.ControladoraPrato;
import br.sc.senac.model.vo.PratoVO;

public class MenuPratos {

	Scanner tec = new Scanner(System.in);
	public void apresentarMenuPratos() {

		
		System.out.println("\n\nFood Truck - Riso & Pasta \n------ Menu Cadastro de Pratos ------");
		System.out.println("\nOpções");
		
		System.out.println("1 - Cadastrar Prato");
		System.out.println("2 - Consultar Prato");
		System.out.println("3 - Atualizar Prato");
		System.out.println("4 - Excluir Prato");
		System.out.println("5 - Voltar");
		System.out.print("\nDigite a Opção: ");

		int opcao = Integer.parseInt(tec.nextLine());

		while (opcao != 5) {
			switch (opcao) {
				case 1: {
					this.cadastrarPrato();
					break;
				}
				case 2: {
					this.consultarPrato();
					break;
				}
				case 3: {
					this.atualizarPrato();
					break;
				}
				case 4: {
					this.excluirPrato();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			
			}
			System.out.println("1 - Cadastrar Prato");
			System.out.println("2 - Consultar Prato");
			System.out.println("3 - Atualizar Prato");
			System.out.println("4 - Excluir Prato");
			System.out.println("5 - Voltar");
			System.out.print("\nDigite a Opção: ");

			opcao = Integer.parseInt(tec.nextLine());
		}
		
	}
	
	private void cadastrarPrato() {
		PratoVO pratoVO = new PratoVO();
		System.out.print("\nDigite o nome do Prato: ");
		pratoVO.setNome(tec.nextLine());
		System.out.print("\nDigite o preço do Prato: ");
		pratoVO.setPreco(Double.parseDouble(tec.nextLine()));
		
		ControladoraPrato controladoraPrato = new ControladoraPrato();
		controladoraPrato.cadastrarPratoController(pratoVO);
	}
	
	private void consultarPrato() {
		System.out.println("\nInforme o tipo de consulta a ser realizada");
		System.out.println("1 - Consultar todos os pratos");
		System.out.println("2 - Consultar um prato especifico");
		System.out.println("3 - Voltar");
		System.out.print("\nDigite a Opção: ");

		int opcao = Integer.parseInt(tec.nextLine());

		ControladoraPrato controladoraPrato = new ControladoraPrato();
			
		while (opcao != 3) {
			switch (opcao) {
				case 1: {
					ArrayList<PratoVO> listaPratosVO = controladoraPrato.consultarTodosPratosController();
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n%3s   %-20s   %-10s\n", "ID", "NOME", "PREÇO");
					for(int i = 0; i < listaPratosVO.size(); i++) {
						listaPratosVO.get(i).imprimir();
					}
					break;
				}
				case 2: {
					PratoVO pratoVO = new PratoVO();
					System.out.print("Informe o codigo do prato: ");
					pratoVO.setIdPrato(Integer.parseInt(tec.nextLine()));
					
					PratoVO prato = controladoraPrato.consultarPratoController(pratoVO);
					System.out.println("\n-------- RESULTADO DA CONSULTA --------");
					System.out.printf("\n%3s   %-20s   %-10s   \n", "ID", "NOME", "PREÇO");
					prato.imprimir();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			}
			System.out.println("\nInforme o tipo de consulta a ser realizada");
			System.out.println("1 - Consultar todos os pratos");
			System.out.println("2 - Consultar um prato especifico");
			System.out.println("3 - Voltar");
			System.out.print("\nDigite a Opção: ");

			opcao = Integer.parseInt(tec.nextLine());
		}
	}
	
	private void atualizarPrato() {
		PratoVO pratoVO = new PratoVO();
		System.out.print("\nInforme o código do Prato: ");
		pratoVO.setIdPrato(Integer.parseInt(tec.nextLine()));
		System.out.print("\nDigite o nome do Prato: ");
		pratoVO.setNome(tec.nextLine());
		System.out.print("\nDigite o preço do Prato: ");
		pratoVO.setPreco(Double.parseDouble(tec.nextLine()));
		
		ControladoraPrato controladoraPrato = new ControladoraPrato();
		controladoraPrato.atualizarPrato(pratoVO);
		
	}

	private void excluirPrato() {
		PratoVO pratoVO = new PratoVO();
		System.out.print("\nInforme o codigo do prato: ");
		pratoVO.setIdPrato(Integer.parseInt(tec.nextLine()));
		
		ControladoraPrato controladoraPrato = new ControladoraPrato();
		controladoraPrato.excluirPrato(pratoVO);
		
	}

}
