package org.primefaces.test.layout.chat;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class ChatBean implements Serializable {
	
	private ChatNegocio negocio = new ChatNegocio();
	
	public void adicionarInteracao() {
		
	}
	
	public void selecionarInteracao(int index) {
		
	}
	
	public void prepararCsv(int index) {
		
	}
	
	public void prepararDadosApresentacao(int index) {
		
	}
	
	public String contatoSelecionado(int index) {
		return "";
	}
}