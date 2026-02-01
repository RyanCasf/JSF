package org.primefaces.test.inicio;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class InicioBean implements Serializable {
	
	private List<LinkDTO> links = LinkDAO.getAll();
	
	public String styleClass(String outcome) {
		String currentView = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		return currentView.equals(outcome.concat(".xhtml")) ? "active" : "";
	}
}