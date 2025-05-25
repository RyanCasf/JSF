package org.primefaces.test.select.menu.custom;

public enum Cor {
	
	VERMELHO("Vermelho", "#FF0000"),
	AZUL("Azul", "#0000FF");
	
	private final String descricao;
	private final String hexadecimal;
	
	Cor(String descricao, String hexadecimal) {
		this.descricao = descricao;
		this.hexadecimal = hexadecimal;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getHexadecimal() {
		return hexadecimal;
	}
}