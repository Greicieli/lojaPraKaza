package br.sc.senai.web.Dominio;

public class Mercadorias {
	private Long idMercadoria;
	private String nome;
	private String categoria;
	private int quantidade;
	private String descricao;
	private Double valor;
	
	public Long getIdMercadoria() {
		return idMercadoria;
	}
	
	public void setIdMercadoria(Long idMercadoria) {
		this.idMercadoria = idMercadoria;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Double getValor() {
		return valor;
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	

}
