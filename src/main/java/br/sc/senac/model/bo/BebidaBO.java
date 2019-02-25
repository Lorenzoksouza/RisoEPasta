package br.sc.senac.model.bo;

import java.util.ArrayList;

import br.sc.senac.model.dao.BebidaDAO;
import br.sc.senac.model.vo.BebidaVO;

public class BebidaBO {

	public void cadastrarBebidaBO(BebidaVO bebidaVO) {

		if(bebidaVO.getNome() == null || bebidaVO.getNome().equals("")) {
			System.out.println("\nNão foi informado o nome do bebida!");
		} else {
			if(bebidaVO.getPreco() <= 0) {
				System.out.println("\nO preço de uma bebida não pode ser menor que R$ 0.00!");

			} else {
				BebidaDAO bebidaDAO = new BebidaDAO();
				if(bebidaDAO.existeRegistoPorNome(bebidaVO.getNome())) {
					System.out.println("\nPrato já cadastrado na base.");
				} else {
					int resultado = bebidaDAO.cadastrarBebidaDAO(bebidaVO);
					if (resultado == 1) {
						System.out.println("\nBebida cadastrado com sucesso!");
					} else {
						System.out.println("\nNão foi possivel cadastrar a bebida!");
					}
				}
			}
		}
		
	}

	public void excluirBebidaBO(BebidaVO bebidaVO) {

		BebidaDAO bebidasDAO = new BebidaDAO();
		if (bebidasDAO.existeRegistroPorIdBebida(bebidaVO.getIdBebida())) {
			int resultado = bebidasDAO.excluirBebidaDAO(bebidaVO);
			if(resultado == 1) {
				System.out.println("\nBebida excluido com sucesso!");
			} else {
				System.out.println("\nNão foi possivel exluir o bebida!");
			}
		} else {
			System.out.println("\nBebida não existe na base de dados!");
		}
		
	}

	public void atualizarBebidaBO(BebidaVO bebidaVO) {

		if(bebidaVO.getIdBebida() == 0) {
			System.out.println("\nNão foi informado o codigo do prato");
		} else {
			if(bebidaVO.getNome() == null || bebidaVO.getNome().equals("")) {
				System.out.println("\nNão foi informado o nome do prato!");
			} else {
				if(bebidaVO.getPreco() <= 0) {
					System.out.println("\nO preço de um prato não pode ser menor que R$ 0.00!");

				} else {
					BebidaDAO bebidaDAO = new BebidaDAO();
					if(bebidaDAO.existeRegistroPorIdBebida(bebidaVO.getIdBebida())) {
						int resultado = bebidaDAO.atualizarBebidaDAO(bebidaVO);
						if(resultado == 1) {
							System.out.println("\nBebida atualizada com sucesso!");
						}else {
							System.out.println("\nNão foi possivel atualizar a bebida!");
						}
					} else {
						System.out.println("\nBebida não existe na base de dados!");
					}
				}
			}
		}
	}

	public ArrayList<BebidaVO> consultarBebidasBO() {
		BebidaDAO bebidaDAO = new BebidaDAO();
		ArrayList<BebidaVO> listaBebidasVO = bebidaDAO.consultarTodasBebidasDAO();
		if(listaBebidasVO.isEmpty()) {
			System.out.println("\nLista de bebidas está vazia!");
		}
		return listaBebidasVO;
	}

	public BebidaVO consultarBebidaBO(BebidaVO bebidaVO) {
		BebidaVO bebida = null;
		if(bebidaVO.getIdBebida() == 0) {
			System.out.println("\nNão foi informado o codigo da bebida");
		} else {
			BebidaDAO bebidaDAO = new BebidaDAO();
			if(bebidaDAO.existeRegistroPorIdBebida(bebidaVO.getIdBebida())) {
				bebida = bebidaDAO.consultarBebidaDAO(bebidaVO);
				if(bebida == null) {
					System.out.println("\nBebida não localizada na base de dados!");
				}
			} else {
				System.out.println("\nBebida não existe na base de dados!");
			}
		}
		return bebida;
	}

}
