package org.primefaces.test.crud.retorno;

import java.util.List;

import lombok.Data;

@Data
public class RetornoNegocio {
	
	private Resultado resultado;
	private String mensagem;
	private List<String> mensagens;
	
	public RetornoNegocio() {
		super();
	}
	
	public RetornoNegocio(Resultado resultado, String mensagem) {
		super();
		this.resultado = resultado;
		this.mensagem = mensagem;
	}
	
	public RetornoNegocio(Resultado resultado, List<String> mensagens) {
		super();
		this.resultado = resultado;
		this.mensagens = mensagens;
	}
	
	public enum Resultado {
		ACEITO, REPROVADO
	}
}