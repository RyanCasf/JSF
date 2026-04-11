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
		System.out.println("adicionarInteracao");
	}
	
	public void selecionarInteracao(int index) {
		System.out.println("selecionarInteracao");
	}
	
	public void prepararCsv(int index) {
		System.out.println("prepararCsv");
	}
	
	public void prepararDadosApresentacao(int index) {
		System.out.println("prepararDadosApresentacao");
	}
	
	public String contatoSelecionado(int index) {
		return "";
	}
}