package br.sc.senac.view;

import java.util.Scanner;

public class MenuCadastro {

	Scanner tec = new Scanner(System.in);
	
	
	public void apresentarMenuCadastro() {

		System.out.println("\nFood Truck - Riso & Pasta \n------ Menu Cadastro ------");
		System.out.println("\nOpções:");
		System.out.println("1 - Cadastrar Pratos");
		System.out.println("2 - Cadastrar Bebidas");
		System.out.println("3 - Voltar");
		System.out.print("\nDigite a opção: ");
		
		int opcao = Integer.parseInt(tec.nextLine());

		while (opcao != 3) {
			switch (opcao) {
				case 1: {
					MenuPratos menuPratos = new MenuPratos();
					menuPratos.apresentarMenuPratos();
					break;
				}
				case 2: {
					MenuBebidas menuBebidas = new MenuBebidas();
					menuBebidas.apresentarMenuBebidas();
					break;
				}
				default: {
					System.out.println("\nOpção Inválida");
				}
			
			}
			
			System.out.println("\nFood Truck - Riso & Pasta \n------ Menu Cadastro ------");
			System.out.println("\nOpções:");
			System.out.println("1 - Cadastrar Pratos");
			System.out.println("2 - Cadastrar Bebidas");
			System.out.println("3 - Voltar");
			System.out.print("\nDigite a opção: ");
			
			opcao = Integer.parseInt(tec.nextLine());
			
		}
	}
}