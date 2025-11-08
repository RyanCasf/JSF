package org.primefaces.test.crud.entidade;

import java.io.Serializable;
import java.util.List;

import org.primefaces.test.crud.constraints.NotNullAndBlank;
import org.primefaces.test.crud.constraints.NotNullAndEmpty;

import lombok.Data;

@Data
public class Entidade implements Serializable {
	
	private Long chave;
	
	@NotNullAndBlank(message = "O campo 'Mensagem' é necessário!")
	private String mensagem;
	
	@NotNullAndEmpty(message = "A lista campos dinâmicos não pode estar vazia!")
	private List<String> camposDinamicos;
}