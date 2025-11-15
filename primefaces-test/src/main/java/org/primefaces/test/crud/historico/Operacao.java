package org.primefaces.test.crud.historico;

import java.util.Date;

import org.primefaces.test.crud.usuario.Usuario;

import lombok.Data;

@Data
public class Operacao {
	
	private Date data;
	private String descricao;
	private Usuario usuario;
	
	public Operacao(Date data, String descricao, Usuario usuario) {
		super();
		this.data = data;
		this.descricao = descricao;
		this.usuario = usuario;
	}
}