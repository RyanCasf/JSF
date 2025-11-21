package org.primefaces.test.datatable;

import java.io.Serializable;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class TabelaKaiBean implements Serializable {
	
	private List<EntidadeKai> entidades = EntidadeKaiBuilder.getAll();
}