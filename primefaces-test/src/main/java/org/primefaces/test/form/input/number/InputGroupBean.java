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
public class InputGroupBean implements Serializable {
	
	private InputTextFilterGroup texto = new InputTextFilterGroup();
	
	public void enviar() {
		String mensagem = "Group: " + texto;
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Group", mensagem));
	}
}