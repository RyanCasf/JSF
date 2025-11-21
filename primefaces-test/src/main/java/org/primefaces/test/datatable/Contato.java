package org.primefaces.test.datatable;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "nome")
public class Contato implements Serializable {
	
	private Long chave;
	private String nome;
	private String cidade;
	private UnidadeFederativa unidadeFederativa;
}