package org.primefaces.test.inicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@SessionScoped
public class InicioBean implements Serializable {
	
	private List<LinkDTO> links = LinkDAO.getAll();
	private Tema tema = Tema.VELA;
	
	public String styleClass(String outcome) {
		String currentView = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		return currentView.equals(outcome.concat(".xhtml")) ? "active" : "";
	}
	
	public String getDados() {
		String conjunto = links.stream()
				.filter(link -> link.getGroup() != null && link.getGroup() != MenuGroup.SEPARATOR)
				.map(link -> {
					String href = "/primefaces-test" + link.getOutcome() + ".jsf";
					return String.format("{ name: \"%s\", desc: \"%s\" }", link.getValue(), href);
				})
				.collect(Collectors.joining(","));
		
		return String.format("[%s]", conjunto);
	}
	
	public void selecionarTema() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("tema", tema);
	}
	
	public List<Tema> getTemas() {
		return new ArrayList<>(Arrays.asList(Tema.values()));
	}
}