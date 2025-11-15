package org.primefaces.test.crud.contexto;

import org.primefaces.test.crud.usuario.Usuario;

public class Contexto {
	
	public static Usuario getUsuatioLogado() {
		return new Usuario();
	}
}