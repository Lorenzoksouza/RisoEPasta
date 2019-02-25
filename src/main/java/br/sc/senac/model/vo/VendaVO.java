package br.sc.senac.model.vo;

import java.util.ArrayList;
import java.util.Date;

public class VendaVO {

	private int idVenda;
	private ArrayList<ItemBebidaVO> itemBebidas;
	private ArrayList<ItemPratoVO> itemPrato;
	private Date dataVenda;
	private int senhaPedido;
	private boolean flagVendaCancelada;
	
	public VendaVO() {
		super();
	}
	
	public VendaVO(int idVenda, ArrayList<ItemBebidaVO> itemBebidas, ArrayList<ItemPratoVO> itemPrato, Date dataVenda,
			int senhaPedido, boolean flagVendaCancelada) {
		super();
		this.idVenda = idVenda;
		this.itemBebidas = itemBebidas;
		this.itemPrato = itemPrato;
		this.dataVenda = dataVenda;
		this.senhaPedido = senhaPedido;
		this.flagVendaCancelada = flagVendaCancelada;
	}
	
	public int getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(int idVenda) {
		this.idVenda = idVenda;
	}
	public ArrayList<ItemBebidaVO> getItemBebidas() {
		return itemBebidas;
	}
	public void setItemBebidas(ArrayList<ItemBebidaVO> itemBebidas) {
		this.itemBebidas = itemBebidas;
	}
	public ArrayList<ItemPratoVO> getItemPrato() {
		return itemPrato;
	}
	public void setItemPrato(ArrayList<ItemPratoVO> itemPrato) {
		this.itemPrato = itemPrato;
	}
	public Date getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}
	public int getSenhaPedido() {
		return senhaPedido;
	}
	public void setSenhaPedido(int senhaPedido) {
		this.senhaPedido = senhaPedido;
	}
	public boolean isFlagVendaCancelada() {
		return flagVendaCancelada;
	}
	public void setFlagVendaCancelada(boolean flagVendaCancelada) {
		this.flagVendaCancelada = flagVendaCancelada;
	}

	
}
