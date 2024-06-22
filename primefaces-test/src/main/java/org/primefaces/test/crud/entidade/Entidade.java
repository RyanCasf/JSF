package org.primefaces.test.crud.entidade;

import java.io.Serializable;

import lombok.Data;

@Data
public class Entidade implements Serializable {
	
	private Long chave;
	private String mensagem;
}