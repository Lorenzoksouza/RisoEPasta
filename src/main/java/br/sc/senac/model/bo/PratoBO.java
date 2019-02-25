package br.sc.senac.model.bo;

import java.util.ArrayList;

import br.sc.senac.model.dao.PratoDAO;
import br.sc.senac.model.vo.PratoVO;

public class PratoBO {

	public void cadastraPratoBO(PratoVO pratoVO) {

		if(pratoVO.getNome() == null || pratoVO.getNome().equals("")) {
			System.out.println("\nNão foi informado o nome do prato!");
		} else {
			if(pratoVO.getPreco() <= 0) {
				System.out.println("\nO preço de um prato não pode ser menor que R$ 0.00!");

			} else {
				PratoDAO pratoDAO = new PratoDAO();
				if(pratoDAO.existeRegistoPorNome(pratoVO.getNome())) {
					System.out.println("\nPrato já cadastrado na base.");
				} else {
					int resultado = pratoDAO.cadastrarPratoDAO(pratoVO);
					if (resultado == 1) {
						System.out.println("\nPrato cadastrado com sucesso!");
					} else {
						System.out.println("\nNão foi possivel cadastrar o prato!");
					}
				}
			}
		}
	}

	public void excluirPratoBO(PratoVO pratoVO) {
		
		PratoDAO pratoDAO = new PratoDAO();
		if (pratoDAO.existeRegistroPorIdPrato(pratoVO.getIdPrato())) {
			int resultado = pratoDAO.excluirPratoDAO(pratoVO);
			if(resultado == 1) {
				System.out.println("\nPrato excluido com sucesso!");
			} else {
				System.out.println("\nNão foi possivel exluir o prato!");
			}
		} else {
			System.out.println("\nPrato não existe na base de dados!");
		}
		
	}

	public void atualizarPratoBO(PratoVO pratoVO) {
		if(pratoVO.getIdPrato() == 0) {
			System.out.println("\nNão foi informado o codigo do prato");
		} else {
			if(pratoVO.getNome() == null || pratoVO.getNome().equals("")) {
				System.out.println("\nNão foi informado o nome do prato!");
			} else {
				if(pratoVO.getPreco() <= 0) {
					System.out.println("\nO preço de um prato não pode ser menor que R$ 0.00!");

				} else {
					PratoDAO pratoDAO = new PratoDAO();
					if(pratoDAO.existeRegistroPorIdPrato(pratoVO.getIdPrato())) {
						int resultado = pratoDAO.atualizarPratoDAO(pratoVO);
						if(resultado == 1) {
							System.out.println("\nPrato atualizado com sucesso!");
						}else {
							System.out.println("\nNão foi possivel atualizar o prato!");
						}
					} else {
						System.out.println("\nPrato não existe na base de dados!");
					}
				}
			}
		}
	}

	public ArrayList<PratoVO> consultarPratosBO() {
		PratoDAO pratoDAO = new PratoDAO();
		ArrayList<PratoVO> listaPratosVO = pratoDAO.consultarTodosPratosDAO();
		if(listaPratosVO.isEmpty()) {
			System.out.println("\nLista de pratos está vazia!");
		}
		return listaPratosVO;
	}

	public PratoVO consultarPratoBO(PratoVO pratoVO) {
		PratoVO prato = null;
		if(pratoVO.getIdPrato() == 0) {
			System.out.println("\nNão foi informado o codigo do prato");
		} else {
			PratoDAO pratoDAO = new PratoDAO();
			if(pratoDAO.existeRegistroPorIdPrato(pratoVO.getIdPrato())) {
				prato = pratoDAO.consultarPratoDAO(pratoVO);
				if(prato == null) {
					System.out.println("\nPrato não localizado na base de dados!");
				}
			} else {
				System.out.println("\nPrato não existe na base de dados!");
			}
		}
		return prato;
	}

}
