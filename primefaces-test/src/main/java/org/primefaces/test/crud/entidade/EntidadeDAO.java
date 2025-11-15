package org.primefaces.test.crud.entidade;

public class EntidadeDAO implements EntidadeInterface {
	
	@Override
	public void salvar(Entidade entidade) {
		
	}
	
	@Override
	public Entidade obter(long chave) {
		Entidade entidade = new Entidade();
		entidade.setChave(chave);
		
		return entidade;
	}
}