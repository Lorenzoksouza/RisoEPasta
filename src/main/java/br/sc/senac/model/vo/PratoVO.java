package br.sc.senac.model.vo;

import java.text.DecimalFormat;

public class PratoVO {

	private int idPrato;
	private String nome;
	private double preco;
	
	public PratoVO(int idPrato, String nome, double preco) {
		super();
		this.idPrato = idPrato;
		this.nome = nome;
		this.preco = preco;
	}
	
	public PratoVO() {
		super();
	}
	
	public int getIdPrato() {
		return idPrato;
	}
	public void setIdPrato(int idPrato) {
		this.idPrato = idPrato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	public void imprimir() {
		DecimalFormat formatador = new DecimalFormat("0.00");
		System.out.printf("%3d   %-20s   %-10s   \n",this.getIdPrato(),this.getNome(),formatador.format(this.getPreco()));
	}
}
