package org.primefaces.test.selectonemenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class ManagerSelectOneMenu implements Serializable {
	
	private List<String> opcoes;
	
	public void carregarOpcoes() {
		if (opcoes != null) {
			return;
		}
		
		System.out.println("Carregar opções");
		
		opcoes = new ArrayList<>();
		opcoes.add("0");
		opcoes.add("1");
		opcoes.add("2");
	}
	
	public List<String> getOpcoes() {
		System.out.println("Pegando Opções");
		return opcoes;
	}
}