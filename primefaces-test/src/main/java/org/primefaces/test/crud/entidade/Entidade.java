package org.primefaces.test.crud.entidade;

import java.io.Serializable;

import org.primefaces.test.crud.constraints.NotNullAndBlank;

import lombok.Data;

@Data
public class Entidade implements Serializable {
	
	private Long chave;
	
	@NotNullAndBlank(message = "O campo 'Mensagem' é necessário!")
	private String mensagem;
}