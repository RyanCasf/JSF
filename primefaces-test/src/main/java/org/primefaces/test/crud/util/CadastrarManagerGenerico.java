package org.primefaces.test.crud.util;

public interface CadastrarManagerGenerico<Negocio> {
	
	void novo();
	
	void setNegocio(Negocio negocio);
	Object getNegocio();
	
	boolean isVisualizar();
	void setVisualizar(boolean visualizar);
}