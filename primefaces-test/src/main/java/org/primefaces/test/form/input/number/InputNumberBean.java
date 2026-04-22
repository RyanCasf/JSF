package org.primefaces.test.form.input.number;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class InputNumberBean implements Serializable {
	
	private Long inteiro;
	
	public void enviar() {
		String mensagem = "Valor: " + inteiro;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Inteiro", mensagem));
	}
}