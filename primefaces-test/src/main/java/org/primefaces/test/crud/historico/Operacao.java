package org.primefaces.test.crud.historico;

import java.util.Date;

import org.primefaces.test.crud.usuario.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Operacao {
	
	private Date data;
	private String descricao;
	private Usuario usuario;
}