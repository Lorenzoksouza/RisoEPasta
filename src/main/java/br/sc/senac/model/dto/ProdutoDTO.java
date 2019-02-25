package br.sc.senac.model.dto;

import java.text.DecimalFormat;

public class ProdutoDTO {

	private int idProduto;
	private String nome;
	private double preco;

	public ProdutoDTO() {
		super();
	}

	public ProdutoDTO(int idProduto, String nome, double preco) {
		super();
		this.idProduto = idProduto;
		this.nome = nome;
		this.preco = preco;
	}

	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
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
		System.out.printf("%3d   %-20s   %-10s   \n",this.getIdProduto(),this.getNome(),formatador.format(this.getPreco()));
	}

}
