package br.bean;

public class Brinquedo {
	int cod;
	String descricao;
	String categoria;
	String Marca;
	String imagem;
	Double preco;
	String detalhes;
	
	public Brinquedo(){
	}
	
	
	public Brinquedo(int cod, String descricao, String categoria, String marca, String imagem, Double preco,
			String detalhes) {
		this.cod = cod;
		this.descricao = descricao;
		this.categoria = categoria;
		Marca = marca;
		this.imagem = imagem;
		this.preco = preco;
		this.detalhes = detalhes;
	}
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getMarca() {
		return Marca;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getDetalhes() {
		return detalhes;
	}
	public void setDetalhes(String detalhes) {
		this.detalhes = detalhes;
	}
	
	@Override
	public String toString() {
		
		return "{ " + this.cod + ", " + this.detalhes + ", " + this.imagem + "}";
	}
	
}
