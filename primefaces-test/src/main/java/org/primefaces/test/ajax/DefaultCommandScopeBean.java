package org.primefaces.test.ajax;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.test.crud.mensagem.Mensagem;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class DefaultCommandScopeBean implements Serializable {
	
	private String nome;
	private String textarea1;
	private String textarea2;
	
	public void btn1Submit() {
		Mensagem.add(FacesMessage.SEVERITY_INFO, "Botão 1");
	}
	
	public void btn2Submit() {
		Mensagem.add(FacesMessage.SEVERITY_INFO, "Botão 2");
	}
}