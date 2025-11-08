package org.primefaces.test.datatable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
public class DataTableBean implements Serializable {
	
	private List<Contato> contatos = new ArrayList<>();
	private Contato contato = new Contato();
	
	public void adicionarContato() {
		if (contato.getNome() == null || contato.getNome().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "O campo 'Nome' está inválido!"));
			return;
		}
		
		if (contato.getCidade() == null || contato.getCidade().trim().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "O campo 'Cidade' está inválido!"));
			return;
		}
		
		if (contatos.contains(contato)) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Aviso", "Contato já existe na lista!"));
			return;
		}
		
		contatos.add(contato);
		contato = new Contato();
	}
	
	public List<UnidadeFederativa> unidadesFederativas(String entrada) {
		System.out.println("getUnidadesFederativas");
		return Arrays.asList(UnidadeFederativa.values()).stream()
				.filter(uf -> entrada != null)
				.filter(uf -> uf.name().contains(entrada))
				.collect(Collectors.toList());
	}
}