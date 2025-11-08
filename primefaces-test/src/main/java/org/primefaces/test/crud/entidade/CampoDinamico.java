package org.primefaces.test.crud.entidade;

import java.io.Serializable;

import org.primefaces.test.crud.constraints.NotNullAndBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "chave" })
public class CampoDinamico implements Serializable {
	
	private Long chave;
	
	@NotNullAndBlank(message = "O campo 'Nome' é necessário!")
	private String nome;
	
	private String valor;
}