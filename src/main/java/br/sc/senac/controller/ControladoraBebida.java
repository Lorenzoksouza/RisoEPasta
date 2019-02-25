package br.sc.senac.controller;

import java.util.ArrayList;

import br.sc.senac.model.bo.BebidaBO;
import br.sc.senac.model.vo.BebidaVO;

public class ControladoraBebida {

	public void cadastrarBebidaController(BebidaVO bebidaVO) {

		BebidaBO bebidaBO = new BebidaBO();
		bebidaBO.cadastrarBebidaBO(bebidaVO);
		
	}

	public void excluirBebida(BebidaVO bebidaVO) {

		BebidaBO bebidaBO = new BebidaBO();
		bebidaBO.excluirBebidaBO(bebidaVO);

	}

	public ArrayList<BebidaVO> consultarTodasBebidasController() {
		
		BebidaBO bebidaBO = new BebidaBO();
		return bebidaBO.consultarBebidasBO();
		
	}

	public BebidaVO consultarBebidasController(BebidaVO bebidaVO) {
		
		BebidaBO bebidaBO = new BebidaBO();
		return bebidaBO.consultarBebidaBO(bebidaVO);
		
	}

	public void atualizarBebida(BebidaVO bebidaVO) {
		
		BebidaBO bebidaBO = new BebidaBO();
		bebidaBO.atualizarBebidaBO(bebidaVO);
		
	}



}
