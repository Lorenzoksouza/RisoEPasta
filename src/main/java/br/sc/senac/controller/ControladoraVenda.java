package br.sc.senac.controller;

import br.sc.senac.model.bo.VendaBO;
import br.sc.senac.model.vo.VendaVO;

public class ControladoraVenda {

	public void cadastrarVendaController(VendaVO vendaVO) {

		VendaBO vendaBO = new VendaBO();
		vendaBO.cadastrarVendaBO(vendaVO);
		
	}

	public void cancelarVendaController(VendaVO vendaVO) {
		
		VendaBO vendaBO = new VendaBO();
		vendaBO.cancelarVendaBO(vendaVO);
				
	}
}
