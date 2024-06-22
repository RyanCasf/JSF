package org.primefaces.test.crud.retorno;

import lombok.Data;

@Data
public class RetornoNegocio {
	
	private Resultado resultado;
	private String mensagem;
	
	public RetornoNegocio() {
		super();
	}
	
	public RetornoNegocio(Resultado resultado, String mensagem) {
		super();
		this.resultado = resultado;
		this.mensagem = mensagem;
	}
	
	public enum Resultado {
		ACEITO, REPROVADO
	}
}