package org.primefaces.test.crud.usuario;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "chave" })
public class Usuario implements Serializable {
	
	private Long chave;
	private String nome;
}