package br.sc.senac.model.vo;

import java.text.DecimalFormat;

public class BebidaVO {
	
	private int idBebida;
	private String nome;
	private double preco;
	
	public BebidaVO(int idBebida, String nome, double preco) {
		super();
		this.idBebida = idBebida;
		this.nome = nome;
		this.preco = preco;
	}
	
	public BebidaVO() {
		super();
	}
	
	public int getIdBebida() {
		return idBebida;
	}
	public void setIdBebida(int idBebida) {
		this.idBebida = idBebida;
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
		System.out.printf("%3d   %-20s   %-10s   \n",this.getIdBebida(),this.getNome(),formatador.format(this.getPreco()));
	}
}
