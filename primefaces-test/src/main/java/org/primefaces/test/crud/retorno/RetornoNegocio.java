package org.primefaces.test.crud.retorno;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RetornoNegocio {
	
	private Resultado resultado;
	private String mensagem;
	private List<String> mensagens;
	
	public enum Resultado {
		ACEITO, REPROVADO
	}
}