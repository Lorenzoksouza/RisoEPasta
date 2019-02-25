package br.sc.senac.model.dto;

import java.text.DecimalFormat;

public class VendaDTO {

	private String tipo;
	private String descricao;
	private double preco;
	private int quantidade;
	private double subtotal;
	
	
	public VendaDTO(String tipo, String descricao, double preco, int quantidade, double subtotal) {
		super();
		this.tipo = tipo;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
		this.subtotal = subtotal;
	}


	public VendaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public double getPreco() {
		return preco;
	}


	public void setPreco(double preco) {
		this.preco = preco;
	}


	public int getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public void imprimir() {
		DecimalFormat formatador = new DecimalFormat("0.00");
		System.out.printf("%3s   %-20s   %-10s  %-10s   %-10s \n",this.getTipo(),this.getDescricao(),this.getQuantidade(),formatador.format(this.getPreco()),formatador.format(this.getSubtotal()));
	}
	
	
	
}
