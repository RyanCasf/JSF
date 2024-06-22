package org.primefaces.test.crud.util;

import org.primefaces.test.crud.retorno.RetornoNegocio;

public interface EntidadeNegocioGenerico {
	
	RetornoNegocio salvar();
	RetornoNegocio carregar(long chave);
}