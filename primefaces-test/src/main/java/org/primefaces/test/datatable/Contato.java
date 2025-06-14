package org.primefaces.test.datatable;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "nome")
public class Contato implements Serializable {
	
	private Long chave;
	private String nome;
	private String cidade;
	private UnidadeFederativa unidadeFederativa;
}