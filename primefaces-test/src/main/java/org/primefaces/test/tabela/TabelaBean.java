package org.primefaces.test.tabela;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.test.datatable.Contato;
import org.primefaces.test.datatable.UnidadeFederativa;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Named
@ViewScoped
public class TabelaBean implements Serializable {
	
	private List<Contato> contatos = new ArrayList<>();
	private Contato contato;
	
	private BloqueioColuna bloqueioPrimeiraColuna = BloqueioColuna.BLOQUEADO;
	
	public TabelaBean() {
		contatos.add(new Contato(0L, "Contato 0", "Poá", UnidadeFederativa.SP));
		contatos.add(new Contato(1L, "Contato 1", "Guarulhos", UnidadeFederativa.SP));
		contatos.add(new Contato(2L, "Contato 2", "Suzano", UnidadeFederativa.SP));
		contatos.add(new Contato(3L, "Contato 3", "Rio de Janeiro", UnidadeFederativa.RJ));
		contatos.add(new Contato(4L, "Contato 4", "Itiruçu", UnidadeFederativa.BA));
	}
	
	public void definirBloquearPrimeiraColuna() {
		bloqueioPrimeiraColuna = bloqueioPrimeiraColuna.toggle();
	}
}