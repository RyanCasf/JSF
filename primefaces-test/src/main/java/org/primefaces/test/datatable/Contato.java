package org.primefaces.test.datatable;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = "nome")
public class Contato implements Serializable {
	
	private Long chave;
	private String nome;
	private String cidade;
	private UnidadeFederativa unidadeFederativa;
}