package org.primefaces.test.select.menu.custom;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Named
@ViewScoped
public class SelectOneMenuBeanColor implements Serializable {
	
	private Cor cor;
	
	public List<Cor> getCores() {
		return new ArrayList<>(Arrays.asList(Cor.values()));
	}
}