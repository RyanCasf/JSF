package org.primefaces.test.datatable;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class EntidadeKai implements Serializable {
	
	private String nome;
	private String pais;
	private String agente;
	private Date data;
	private BigDecimal salario;
	private StatusKai status;
}