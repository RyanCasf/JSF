package org.primefaces.test.crud.entidade;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.primefaces.test.crud.constraints.NotNullAndBlank;
import org.primefaces.test.crud.constraints.NotNullAndEmpty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = { "chave" })
public class Entidade implements Serializable {
	
	private Long chave;
	
	@NotNullAndBlank(message = "O campo 'Mensagem' é necessário!")
	private String mensagem;
	
	@Valid
	@NotNullAndEmpty(message = "A lista campos dinâmicos não pode estar vazia!")
	private List<CampoDinamico> camposDinamicos;
}