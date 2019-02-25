package br.sc.senac.controller;

import java.util.ArrayList;

import br.sc.senac.model.bo.PratoBO;
import br.sc.senac.model.vo.PratoVO;

public class ControladoraPrato {

	public void cadastrarPratoController(PratoVO pratoVO) {

		PratoBO pratoBO = new PratoBO();
		pratoBO.cadastraPratoBO(pratoVO);
		
	}

	public void excluirPrato(PratoVO pratoVO) {

		PratoBO pratoBO = new PratoBO();
		pratoBO.excluirPratoBO(pratoVO);
		
	}

	public ArrayList<PratoVO> consultarTodosPratosController() {
		
		PratoBO pratoBO = new PratoBO();
		return pratoBO.consultarPratosBO();
		
	}

	public PratoVO consultarPratoController(PratoVO pratoVO) {

		PratoBO pratoBO = new PratoBO();
		return pratoBO.consultarPratoBO(pratoVO);
		
	}

	public void atualizarPrato(PratoVO pratoVO) {
		
		PratoBO pratoBO = new PratoBO();
		pratoBO.atualizarPratoBO(pratoVO);
		
	}

}
