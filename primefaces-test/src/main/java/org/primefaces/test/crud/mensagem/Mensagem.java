package org.primefaces.test.crud.mensagem;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class Mensagem {
	
	public static void add(Severity severity, String summary) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, null));
	}
}