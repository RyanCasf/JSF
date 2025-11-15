package org.primefaces.test.crud.entidade;

public interface EntidadeInterface {
	
	void salvar(Entidade entidade);
	Entidade obter(long chave);
}